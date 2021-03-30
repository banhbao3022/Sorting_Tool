# Sorting_Tool
**A simple sorting_tool work in Java console. It will read data from user input or text file, sort it by word or line and determine the biggest or most frequent pieces of data 
and perform the necessary calculations on them.**

**There are 4 aguments you can choose:(-sortingType/-dataType/-inputFile/-outputFile)**

* SortingType: There are 2 types: natural,which will sort data in Lexicographic order or byCount, which count and sort data by the percentage of frequency. If -sortingType isn't provided,
natural will be the default sorting type

* DataType: You can choose sort data by each word or line. If -dataType isn't provided, line will be the default data type

* InputFile: It will read data from text file and sort it. If -inputFile isn't provided, you will type data from console and type the end-of-file symbol(CTRL + D) to end data

* OutputFile: It will write the result to output file. If -inputFile isn't provided, it will use the result from user input. If output file doesn't exists, it will create new file
and write to it

**And if you type wrong aguments. It'll throw exception so be careful**

Some test case:

Sample text:

Once upon a time there was a very rich man who lived with his three daughters.
The two older daughters laughed at anyone who did not dress as well as they did.
If they were not going to a ball, they were shopping for as many fine dresses and hats as they could carry home.

https://gist.github.com/banhbao3022/d310d10ecad6bbc1d47ee6955a00943c
