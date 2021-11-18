import org.junit.After
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @After
    fun tearDown() {
    }

    @Test
    fun calcComitionOfTransfer_VkPayZerro() {
        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_VKPAY
        var amountOfPreviusMonthPeriod = 0
        var transferAmount = 14_000_00

        // act — выполнение целевого действия (вызов функции).
//        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
//
//        // assert — сравнение ожидаемого результата с фактическим.
//        assertEquals(0, result)
    }

    @Test
    fun calcComitionOfTransfer_VkPayOneTimeLimit() {
        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_VKPAY
        var amountOfPreviusMonthPeriod = 0
        var transferAmount = 16_000_00

        // act — выполнение целевого действия (вызов функции).
//        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
//
//        // assert — сравнение ожидаемого результата с фактическим.
//        assertEquals(0, result)
    }

    @Test
    fun calcComitionOfTransfer_VkPayMonthLimit() {
        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_VKPAY
        var amountOfPreviusMonthPeriod = 39_000_00
        var transferAmount = 11_000_00

        // act — выполнение целевого действия (вызов функции).
//        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
//
//        // assert — сравнение ожидаемого результата с фактическим.
//        assertEquals(0, result)
    }

    @Test
    fun calcComitionOfTransfer_AnyCardMonthLimit() {
        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_MIR
        var amountOfPreviusMonthPeriod = 599_000_00
        var transferAmount = 11_000_00

        // act — выполнение целевого действия (вызов функции).
//        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
        val result = calcComitionOfTransfer(typeOfCard, amountOfPreviusMonthPeriod, transferAmount)
//
//        // assert — сравнение ожидаемого результата с фактическим.
//        assertEquals(0, result)
    }

    @Test
    fun printMassageOfTransfer_Easy() {

        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_VKPAY
        var transferAmount = 16_000
        var comissionOfTransfer = 0

        // act — выполнение целевого действия (вызов функции).
        printMassageOfTransfer(typeOfCard, transferAmount, comissionOfTransfer)

        // assert — сравнение ожидаемого результата с фактическим.
        //assertEquals(0, result)
    }

    @Test
    fun calcFullComitionOfTransfer_TestVKPay() {

        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_VKPAY
        var transferAmount = 14_000

        // act — выполнение целевого действия (вызов функции).
        val result = calcFullComitionOfTransfer(typeOfCard, transferAmount)

        // assert — сравнение ожидаемого результата с фактическим.
        assertEquals(12, result)
    }

    @Test
    fun calcFullComitionOfTransfer_TestVisaPay() {

        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_VISA
        var transferAmount = 24_000

        // act — выполнение целевого действия (вызов функции).
        val result = calcFullComitionOfTransfer(typeOfCard, transferAmount)

        // assert — сравнение ожидаемого результата с фактическим.
        assertEquals(3500, result)
    }

    @Test
    fun calcFullComitionOfTransfer_TestMirPayBig() {

        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_MIR
        var transferAmount = 560_000

        // act — выполнение целевого действия (вызов функции).
        val result = calcFullComitionOfTransfer(typeOfCard, transferAmount)

        // assert — сравнение ожидаемого результата с фактическим.
        assertEquals(4200, result)
    }

    @Test
    fun calcFullComitionOfTransfer_TestMasterPay() {

        // arrange - подготовка данных (задание переменных).
        var typeOfCard = TYPE_CARD_MASTER
        var transferAmount = 24_000

        // act — выполнение целевого действия (вызов функции).
        val result = calcFullComitionOfTransfer(typeOfCard, transferAmount)

        // assert — сравнение ожидаемого результата с фактическим.
        assertEquals(2144, result)
    }

    @Test
    fun calcFullComitionOfTransfer_WrongCard() {

        // arrange - подготовка данных (задание переменных).
        var typeOfCard = "None"
        var transferAmount = 32_000

        // act — выполнение целевого действия (вызов функции).
        val result = calcFullComitionOfTransfer(typeOfCard, transferAmount)

        // assert — сравнение ожидаемого результата с фактическим.
        assertEquals(0, result)
    }
}