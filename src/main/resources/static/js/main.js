// Função para atualizar os valores
function atualizarValores() {
    var entradaTotal = 0;
    var saidaTotal = 0;

    // Iterar sobre as linhas da tabela
    document.querySelectorAll('table tbody tr').forEach(function(row) {
        // Obter os valores da coluna "tipo" e "valor"
        var tipo = row.querySelector('td:nth-child(3)').innerText;
        var valor = parseFloat(row.querySelector('td:nth-child(2)').innerText);

        // Atualizar os totais com base no tipo
        if (tipo.toLowerCase() === 'entrada') {
            entradaTotal += valor;
        } else if (tipo.toLowerCase() === 'saida') {
            saidaTotal += valor;
        }
    });

    // Atualizar os elementos HTML com os novos totais
    document.querySelector('.incomes').innerText = entradaTotal.toFixed(2);
    document.querySelector('.expenses').innerText = saidaTotal.toFixed(2);
    document.querySelector('.total').innerText = (entradaTotal - saidaTotal).toFixed(2);
}

// Chamar a função inicialmente e sempre que houver mudanças na tabela
document.addEventListener('DOMContentLoaded', function() {
    atualizarValores();
});

// Função para formatar a data
function formatarDataParaString(data) {
    // Obter as partes da data
    var dia = data.getDate().toString().padStart(2, '0');
    var mes = (data.getMonth() + 1).toString().padStart(2, '0'); // Meses começam do zero, então somamos 1
    var ano = data.getFullYear().toString();

    // Retornar a string formatada
    return dia + ' ' + mes + ' ' + ano;
}

// Exemplo de uso:
var dataAtual = new Date();
var dataFormatada = formatarDataParaString(dataAtual);

console.log(dataFormatada); // Saída: "dd mm aaaa" (por exemplo, "01 02 2023")
