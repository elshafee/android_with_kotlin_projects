import java.time.LocalDate

class AppleBrand(name: String) : Mobile() {
    val name = name
    var selectedOption: Int = 0
    var length: Int = 0
    var date = LocalDate.now()
    val fixed: Int = 1500
    val memory: List<Int> = listOf(16, 32, 64, 128, 256, 512)
    val ram: List<String> = listOf("1", "1", "1", "2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4")
    val prices: ArrayList<Int> = ArrayList()
    var selectedColor: String = ""
    var selectedMemory: Int = 0
    var selectedModel: String = ""
    var ran: Int = 0
    var x: Int = 0


    var models: List<String> = listOf(
        "Iphone 6",
        "Iphone 6 plus",
        "Iphone 6s plus",
        "Iphone 7",
        "Iphone 8",
        "Iphone 8 plus",
        "Iphone x",
        "Iphone xr",
        "Iphone xs",
        "Iphone x plus",
        "Iphone 11",
        "Iphone 11 pro",
        "Iphone 11 pro max"
    )
    var colors: List<String> = listOf("Black", "Red", "Blue", "Silver")


    override fun Ram(index: Int) {
        ran =
            index - 1      // because the array index starts from Zero so if the phone order is 1 in the user screen it number in list is 0
        println("Ram: ${ram[index]} GB")
    }

    override fun Memory(index: Int) {
        when (index) {
            in 1..3 -> {
                //16
                println("available Memory for this model is:")
                for (i in 0..3) {
                    println("${i} => ${memory[i]}")
                }
                selectedOption = Integer.valueOf(readLine())
                when (selectedOption) {
                    in 0..3 -> {
                        selectedMemory = memory[selectedOption]
                        Color(index)
                    }
                    else -> {
                        println("out of range")
                        Memory(x)
                    }
                }
            }
            else -> {
                // models from  7
                length = (memory.size) - 1
                for (i in 2..length) {
                    println("${i} => ${memory[i]}")
                }
                selectedOption = Integer.valueOf(readLine())
                when (selectedOption) {
                    in 2..length -> {
                        selectedMemory = memory[selectedOption]
                        Color(index)
                    }
                    else -> {
                        println("out of range")
                        Memory(x)
                    }
                }

            }
        }
    }

    override fun OperatSys(index: Int) {
        println("Operating System is : IOS")
    }


    override fun Model() {
        println("These are the available Models Please select the Model you need to proceed")
        length = (models.size) - 1
        for (i in 0..length) {
            println("${i} => ${models[i]},")
        }
        println("${length + 1}=> I didn't Found my model,")
        selectedOption = Integer.valueOf(readLine())
        when (selectedOption) {
            in 0..length -> {
                x = selectedOption

                selectedModel = models[selectedOption]
                Memory(selectedOption)
            }
            length +1 -> {
                println("we are very sorry for that")
                println("Thanks for Visiting Elshafee Store")
            }
            else -> {
                println("Out of range")
                Model()
            }
        }


    }

    override fun Price(index: Int) {
        length = models.size
        for (i in 0..length) {
            var tot = fixed + (500 * i)
            prices.add(tot)
        }
        println("Price is ${prices[index]}")
    }

    override fun OPVersion(index: Int) {
        println("Current Software Version is: 15.3")
    }

    override fun SecurityOp(index: Int) {
        when (x) {
            in 0..6 -> println("Security Option is : TouchID")
            else -> println("Security Option is : FacID")
        }
    }

    override fun Waranty(index: Int) {
        println("This device has a warranty for a year")
        println("Starts from : ${date}")
        println("Ends ON : ${(date.year) + 1}-${date.month}-${date.dayOfMonth}")
    }

    override fun BrandName(index: Int) {
        println("Brand Name is Apple")
    }

    override fun ExSupport(index: Int) {
        println("Latest IOS version Support:  yes")
    }


    override fun Color(index: Int) {
        length = (colors.size) - 1
        for (i in 0..length) {
            println("${i} => ${colors[i]},")
        }
        selectedOption = Integer.valueOf(readLine())
        when (selectedOption) {
            in 0..length -> {
                selectedColor = colors[selectedOption]
                OrderSummary()
            }
            else -> {
                println("Out Of Range")
                Color(index)
            }
        }


    }

    fun OrderSummary() {
        println("Order Summary")
        println("Customer Name: ${name}")
        println("Your Device Model: ${selectedModel}")
        BrandName(1)
        OperatSys(1)
        OPVersion(1)
        SecurityOp(1)
        println("Device Color is: ${selectedColor}")
        Waranty(1)
        ExSupport(1)
        Price(x)
        println("<--Thanks For Visiting Elshafee Store-->")

    }


}