const val TYPE_CARD_VKPAY = "VК Pay"
const val TYPE_CARD_MASTER = "Mastercard"
const val TYPE_CARD_MAESTRO = "Maestro"
const val TYPE_CARD_VISA = "Visa"
const val TYPE_CARD_MIR = "МИР"

const val MAX_CARD_TRANSFER_DAY = 15_000_000 //Максимальная сумма сумма переводов по одной карте в сутки
const val MAX_CARD_TRANSFER_MONTH = 60_000_000 //Максимальная сумма сумма переводов по одной карте в месяц

const val MAX_VPAY_TRANSFER_ONE_TIME = 1_500_000 //Максимальная сумма сумма переводов по VK Pay за один раз
const val MAX_VPAY_TRANSFER_MONTH = 4_000_000 //Максимальная сумма сумма переводов по VK Pay в месяц


fun main(){
    var typeOfCard = TYPE_CARD_VKPAY // Тип счета по умолчанию
    var amountOfPreviusMonthPeriod = 0 //Сумму предыдущих переводов в этом месяце (по умолчанию - 0).
//    var amountOfDay = 0 //Сумма переводов за сутки (по умолчанию - 0).
    var transferAmount = 1400000 // Сумма перевода в коп.

    calcComitionOfTransfer(typeOfCard = TYPE_CARD_VKPAY, amountOfPreviusMonthPeriod = 0, transferAmount)
}

fun calcComitionOfTransfer(typeOfCard: String, amountOfPreviusMonthPeriod: Int, transferAmount: Int) {
    if (typeOfCard == TYPE_CARD_VKPAY){
        if (transferAmount >= MAX_VPAY_TRANSFER_ONE_TIME){
            println("Превышен лимит суммы перевода за один раз.")
        }else if((amountOfPreviusMonthPeriod+transferAmount)> MAX_VPAY_TRANSFER_MONTH){
            println("Сумма превышает месячный лимит переводов.")
        }else{
            var comissionOfTransfer = calcFullComitionOfTransfer(typeOfCard, transferAmount)
            printMassageOfTransfer(typeOfCard, transferAmount, comissionOfTransfer)
        }
    } else if (typeOfCard == TYPE_CARD_MAESTRO||
        typeOfCard == TYPE_CARD_MIR||
        typeOfCard == TYPE_CARD_VISA||
        typeOfCard ==TYPE_CARD_MASTER){
        if((amountOfPreviusMonthPeriod+transferAmount)> MAX_CARD_TRANSFER_MONTH){
            println("Сумма превышает месячный лимит переводов.")
        }/*else if((amountOfDay + transferAmount) >= MAX_CARD_TRANSFER_DAY){
            println("Превышен лимит суммы перевода за сутки.")
        }*/else{
            var comissionOfTransfer = calcFullComitionOfTransfer(typeOfCard, transferAmount)
            printMassageOfTransfer(typeOfCard, transferAmount, comissionOfTransfer)
        }
    }
}

// Функция вывода сообщения о переводе с суммой комиссии за перевод
fun printMassageOfTransfer(typeOfCard: String, transferAmount: Int, comissionOfTransfer: Int) {
    println("Сумма перевода на $typeOfCard: ${transferAmount / 100} руб. ${transferAmount % 100} коп., " +
            "комиссия за перевод ${comissionOfTransfer / 100} руб. ${comissionOfTransfer % 100} коп.")

}

// Функция расчета суммы комиссии в зависимости от типа карты
fun calcFullComitionOfTransfer(typeOfCard: String, transferAmount: Int): Int {
    when (typeOfCard){
        TYPE_CARD_VKPAY -> return 0
        TYPE_CARD_MIR, TYPE_CARD_VISA ->
            if ((transferAmount*0.0075).toInt()>3500) {
                return (transferAmount*0.0075).toInt()
            }else{return 3500}
        TYPE_CARD_MASTER, TYPE_CARD_MAESTRO -> return ((transferAmount*0.006).toInt()+2000)
    }
    return 0
}

