package br.com.cotemig.Ithalo.models

class Fatura {
    var limiteDisponivel: String = ""
    var valor: String = ""
    var vencimento: String = ""
    var despesas: List<ListaDespesa> = emptyList()
}