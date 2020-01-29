
#First of all, we create the txt files given to us and read them to our python file.
my_matrix = open("distance_matrix.txt", "r")
my_label = open("labels.txt", "r")

#we create two empty arrays, explain why after.
array1 = []
array2 = []

#strip(‘\n’) means stripping out newline character form beginning and end of given string.After array1 adding its argument as a single element to the end of a list.
for i in my_matrix:
    i = i.strip("\n")
    array1.append(i)
#array 2 by line strip separated by commas

for line in my_label:
    array2 = line.strip("(").strip(")").split(",")
#The reason I removed from 10 is that the names are at least proportional and print array 1 and 2
x = len(array1)
for i in range(x):
    print(array1[i] + (10 - len(array1[i])) * " " + array2[i])

