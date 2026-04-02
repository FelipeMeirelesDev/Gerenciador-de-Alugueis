document.getElementById("formImovel").addEventListener("submit", async function (event) {
    event.preventDefault();

    const imovel = {
        bairro: document.getElementById("bairro").value,
        rua: document.getElementById("rua").value,
        numero: document.getElementById("numero").value,
        valorAluguel: parseFloat(document.getElementById("valorAluguel").value),
        disponibilidade: document.getElementById("disponibilidade").value === "true"
    };

    try {
        const resposta = await fetch("/api/imoveis", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(imovel)
        });

        const mensagem = document.getElementById("mensagem");

        if (resposta.ok) {
            mensagem.innerText = "Imóvel salvo com sucesso!";
            mensagem.style.color = "green";
            document.getElementById("formImovel").reset();
        } else {
            mensagem.innerText = "Erro ao salvar imóvel.";
            mensagem.style.color = "red";
        }

    } catch (erro) {
        console.error("Erro ao enviar dados:", erro);
        const mensagem = document.getElementById("mensagem");
        mensagem.innerText = "Erro na comunicação com o servidor.";
        mensagem.style.color = "red";
    }
});