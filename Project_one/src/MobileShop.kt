import kotlin.system.exitProcess

class MobileShop {

    var nameOnCard: String = ""
    var balance: Float = 0f
    var pic: Int = 0
    var selectedOption: Int = 0


    fun enterYourCard() {
        println("<--Welcome to Elshafee Mobile Store-->")
        print("Please enter Your name : ")
        nameOnCard = readLine().toString()

        selectOperations()
    }

    fun selectOperations() {
        println("Please select your operation you need to proceed")
        println("1 => For Buy Selected Mobile Example: (I will buy BrandName Mobile Model No.),")
        println("2 => For Buy Depending on your budget,")
        println("3 => For Exit")

        selectedOption = Integer.valueOf(readLine())
        when (selectedOption) {
            1 -> BrandSelection()
            2 -> Budget()
            3 -> println("Thanks for visiting Elshafee Mobile Store")
        }

    }


    fun BrandSelection() {
        println("Hint: apple, samsung or huawei")
        print("Insert Your Mobile Brand : ")
        var brand: String = readLine().toString()

        brand = brand.lowercase()
        var appleBrand = AppleBrand(nameOnCard)
        var samsungBrand = SamsungBrand(nameOnCard)
        var huaweiBrand = HuaweiBrand(nameOnCard)



        when (brand) {
            "apple" -> appleBrand.Model()
            "samsung" -> samsungBrand.Model()
            "huawei" -> huaweiBrand.Model()
            else -> {
                println("Out Of Range")
                println("Please try again")
                BrandSelection()
            }

        }


    }

    fun Budget() {
        println("[1500 -> 12000] LE")
        print("Insert Your Budget Amount: ")

        var amount: Int = Integer.valueOf(readLine())
        var appleBrand = AppleBrand(nameOnCard)
        var samsungBrand = SamsungBrand(nameOnCard)
        var huaweiBrand = HuaweiBrand(nameOnCard)
        var length = appleBrand.models.size
        var model = appleBrand.models
        var prices = appleBrand.prices
        for (i in 0..length) {
            var tot = 1500 + (500 * i)
            prices.add(tot)
        }
        println("<--------------------------------------------->")
        println("We will show you specific Mobiles depending to your budget then you will enter the model you loved and continue the process")
        println("<--------------------------------------------->")

        when (amount) {
            in 0..3000 -> {
                for (i in 0..length) {
                    var la = prices[i]
                    if (amount >= la) {
                        var pric: ArrayList<Int> = ArrayList()
                        pric.add(i)
                        pic = pric.size
                    }
                }

            }
            in 3000..6000 -> {
                for (i in 0..length) {
                    var la = prices[i]
                    if (amount >= la) {
                        var pric: ArrayList<Int> = ArrayList()
                        pric.add(i)
                        pic = pric.size
                    }
                }
            }
            in 6000..120000 -> {
                for (i in 0..length) {
                    var la = prices[i]
                    if (amount >= la) {
                        var pric: ArrayList<Int> = ArrayList()
                        pric.add(i)
                        pic = pric.size
                    }
                }
            }
        }

        for (i in 0..pic) {
            println("Mobile Model: ${model[i]}")
            println("Mobile Operating System: ${appleBrand.OperatSys(i)}")
            println("Mobile Memory: ${appleBrand.memory}")
            println("Mobile Ram: ${appleBrand.Ram(i)}")
            println("Mobile Support Latest Version: ${appleBrand.ExSupport(i)}")
            println("Mobile  Software Version: ${appleBrand.OPVersion(i)}")
            println("<--------------------------------------------->")
        }
        for (i in 0..pic) {
            println("Mobile Model: ${samsungBrand.models[i]}")
            println("Mobile Operating System: ${samsungBrand.OperatSys(i)}")
            println("Mobile Memory: ${samsungBrand.memory}")
            println("Mobile Ram: ${samsungBrand.Ram(i)}")
            println("Mobile Support Latest Version: ${samsungBrand.ExSupport(i)}")
            println("Mobile  Software Version: ${samsungBrand.OPVersion(i)}")
            println("<--------------------------------------------->")

        }
        for (i in 0..pic) {
            println("Mobile Model: ${huaweiBrand.models[i]}")
            println("Mobile Operating System: ${huaweiBrand.OperatSys(i)}")
            println("Mobile Memory: ${huaweiBrand.memory}")
            println("Mobile Ram: ${huaweiBrand.Ram(i)}")
            println("Mobile Support Latest Version: ${huaweiBrand.ExSupport(i)}")
            println("Mobile  Software Version: ${huaweiBrand.OPVersion(i)}")
            println("<--------------------------------------------->")

        }

        BrandSelection()


    }


    fun doYouNeedAnyThing() {
        println("Do You need anything else?!")
        println("1 => For Yes,")
        println("2 => For No,")
        selectedOption = Integer.valueOf(readln())
        when (selectedOption) {
            1 -> selectOperations()
            2 -> {
                println("<--Thanks For Visiting Elshafee Store-->")
                exitProcess(0)
            }
        }

    }


}