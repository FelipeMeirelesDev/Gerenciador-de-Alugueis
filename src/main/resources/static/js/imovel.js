const form = document.getElementById("formImovel");
const mensagem = document.getElementById("mensagem");
const tabelaImoveis = document.getElementById("tabelaImoveis");

const totalImoveis = document.getElementById("totalImoveis");
const imoveisDisponiveis = document.getElementById("imoveisDisponiveis");
const imoveisIndisponiveis = document.getElementById("imoveisIndisponiveis");

const modalOverlay = document.getElementById("modalOverlay");
const btnAbrirModal = document.getElementById("btnAbrirModal");
const btnFecharModal = document.getElementById("btnFecharModal");
const btnCancelar = document.getElementById("btnCancelar");

const tituloModal = document.getElementById("tituloModal");
const btnSalvar = document.getElementById("btnSalvar");
const imovelId = document.getElementById("imovelId");

// ============================
// MODAL EXCLUIR
// ============================
const modalExcluirOverlay = document.getElementById("modalExcluirOverlay");
const btnFecharExcluir = document.getElementById("btnFecharExcluir");
const btnCancelarExcluir = document.getElementById("btnCancelarExcluir");
const btnConfirmarExcluir = document.getElementById("btnConfirmarExcluir");

const deleteBairro = document.getElementById("deleteBairro");
const deleteRua = document.getElementById("deleteRua");
const deleteNumero = document.getElementById("deleteNumero");
const deleteValor = document.getElementById("deleteValor");
const deleteDisponibilidade = document.getElementById("deleteDisponibilidade");

let idParaExcluir = null;

// ============================
// MODAL CADASTRO / EDIÇÃO
// ============================
function abrirModal() {
    modalOverlay.classList.add("active");
}

function fecharModal() {
    modalOverlay.classList.remove("active");
    form.reset();
    imovelId.value = "";
    tituloModal.textContent = "Adicionar Imóvel";
    btnSalvar.textContent = "Salvar Imóvel";
}

function abrirModalCadastro() {
    form.reset();
    imovelId.value = "";
    tituloModal.textContent = "Adicionar Imóvel";
    btnSalvar.textContent = "Salvar Imóvel";
    abrirModal();
}

btnAbrirModal.addEventListener("click", abrirModalCadastro);
btnFecharModal.addEventListener("click", fecharModal);
btnCancelar.addEventListener("click", fecharModal);

modalOverlay.addEventListener("click", function (e) {
    if (e.target === modalOverlay) {
        fecharModal();
    }
});

// ============================
// MODAL EXCLUIR
// ============================
function abrirModalExcluir() {
    modalExcluirOverlay.classList.add("active");
}

function fecharModalExcluir() {
    modalExcluirOverlay.classList.remove("active");
    idParaExcluir = null;
}

btnFecharExcluir.addEventListener("click", fecharModalExcluir);
btnCancelarExcluir.addEventListener("click", fecharModalExcluir);

modalExcluirOverlay.addEventListener("click", function (e) {
    if (e.target === modalExcluirOverlay) {
        fecharModalExcluir();
    }
});

// ============================
// LISTAR IMÓVEIS
// ============================
async function carregarImoveis() {
    try {
        const response = await fetch("/api/imoveis");

        if (!response.ok) {
            throw new Error("Erro ao buscar imóveis");
        }

        const imoveis = await response.json();

        tabelaImoveis.innerHTML = "";

        let disponiveis = 0;
        let indisponiveis = 0;

        if (imoveis.length === 0) {
            tabelaImoveis.innerHTML = `
                <tr>
                    <td colspan="6" style="text-align:center; padding: 20px;">
                        Nenhum imóvel cadastrado.
                    </td>
                </tr>
            `;
        }

        imoveis.forEach(imovel => {
            if (imovel.disponibilidade) {
                disponiveis++;
            } else {
                indisponiveis++;
            }

            const linha = `
                <tr>
                    <td>${imovel.bairro ?? "-"}</td>
                    <td>${imovel.rua ?? "-"}</td>
                    <td>${imovel.numero ?? "-"}</td>
                    <td>R$ ${Number(imovel.valor_aluguel ?? 0).toFixed(2).replace(".", ",")}</td>
                    <td class="status-cell">
                        <span class="status-badge ${imovel.disponibilidade ? 'status-disponivel' : 'status-indisponivel'}">
                            ${imovel.disponibilidade ? "Disponível" : "Indisponível"}
                        </span>
                    </td>
                    <td class="actions-cell">
                        <div class="action-buttons">
                            <button class="btn-icon btn-edit" onclick="editarImovel(${imovel.id})" title="Editar">
                                ✏️
                            </button>
                            <button class="btn-icon btn-delete" onclick="abrirConfirmacaoExclusao(${imovel.id})" title="Excluir">
                                🗑️
                            </button>
                        </div>
                    </td>
                </tr>
            `;
            tabelaImoveis.innerHTML += linha;
        });

        totalImoveis.textContent = imoveis.length;
        imoveisDisponiveis.textContent = disponiveis;
        imoveisIndisponiveis.textContent = indisponiveis;

    } catch (error) {
        console.error("Erro ao carregar imóveis:", error);
        tabelaImoveis.innerHTML = `
            <tr>
                <td colspan="6" style="text-align:center; padding: 20px; color:red;">
                    Erro ao carregar imóveis.
                </td>
            </tr>
        `;
    }
}

// ============================
// EDITAR IMÓVEL
// ============================
async function editarImovel(id) {
    try {
        const response = await fetch(`/api/imoveis/${id}`);

        if (!response.ok) {
            throw new Error("Erro ao buscar imóvel");
        }

        const imovel = await response.json();

        imovelId.value = imovel.id;
        document.getElementById("bairro").value = imovel.bairro ?? "";
        document.getElementById("rua").value = imovel.rua ?? "";
        document.getElementById("numero").value = imovel.numero ?? "";
        document.getElementById("valorAluguel").value = imovel.valor_aluguel ?? "";
        document.getElementById("disponibilidade").value = String(imovel.disponibilidade);

        tituloModal.textContent = "Editar Imóvel";
        btnSalvar.textContent = "Salvar Alterações";

        abrirModal();

    } catch (error) {
        console.error("Erro ao carregar imóvel para edição:", error);
        mensagem.textContent = "Erro ao carregar imóvel para edição.";
        mensagem.style.color = "red";
    }
}

// ============================
// ABRIR CONFIRMAÇÃO DE EXCLUSÃO
// ============================
async function abrirConfirmacaoExclusao(id) {
    try {
        const response = await fetch(`/api/imoveis/${id}`);

        if (!response.ok) {
            throw new Error("Erro ao buscar imóvel");
        }

        const imovel = await response.json();

        idParaExcluir = imovel.id;

        deleteBairro.textContent = imovel.bairro ?? "-";
        deleteRua.textContent = imovel.rua ?? "-";
        deleteNumero.textContent = imovel.numero ?? "-";
        deleteValor.textContent = `R$ ${Number(imovel.valor_aluguel ?? 0).toFixed(2).replace(".", ",")}`;
        deleteDisponibilidade.textContent = imovel.disponibilidade ? "Disponível" : "Indisponível";

        abrirModalExcluir();

    } catch (error) {
        console.error("Erro ao carregar imóvel para exclusão:", error);
        mensagem.textContent = "Erro ao carregar imóvel para exclusão.";
        mensagem.style.color = "red";
    }
}

// ============================
// EXCLUIR IMÓVEL
// ============================
btnConfirmarExcluir.addEventListener("click", async function () {
    if (!idParaExcluir) return;

    try {
        const response = await fetch(`/api/imoveis/${idParaExcluir}`, {
            method: "DELETE"
        });

        if (response.ok) {
            mensagem.textContent = "Imóvel excluído com sucesso!";
            mensagem.style.color = "green";
            fecharModalExcluir();
            carregarImoveis();
        } else {
            mensagem.textContent = "Erro ao excluir imóvel.";
            mensagem.style.color = "red";
        }
    } catch (error) {
        console.error("Erro ao excluir imóvel:", error);
        mensagem.textContent = "Erro ao conectar com o servidor.";
        mensagem.style.color = "red";
    }
});

// ============================
// SALVAR / ATUALIZAR IMÓVEL
// ============================
form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const id = imovelId.value;

    const imovel = {
        bairro: document.getElementById("bairro").value,
        rua: document.getElementById("rua").value,
        numero: document.getElementById("numero").value,
        valor_aluguel: parseFloat(document.getElementById("valorAluguel").value),
        disponibilidade: document.getElementById("disponibilidade").value === "true"
    };

    const url = id ? `/api/imoveis/${id}` : "/api/imoveis";
    const metodo = id ? "PUT" : "POST";

    try {
        const response = await fetch(url, {
            method: metodo,
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(imovel)
        });

        if (response.ok) {
            mensagem.textContent = id
                ? "Imóvel atualizado com sucesso!"
                : "Imóvel salvo com sucesso!";

            mensagem.style.color = "green";

            fecharModal();
            carregarImoveis();
        } else {
            mensagem.textContent = "Erro ao salvar imóvel.";
            mensagem.style.color = "red";
        }
    } catch (error) {
        console.error("Erro:", error);
        mensagem.textContent = "Erro ao conectar com o servidor.";
        mensagem.style.color = "red";
    }
});

// carregar ao abrir a página
carregarImoveis();