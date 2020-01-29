
#Read txt
matrix_data = open("distance_matrix.txt", "r")
labels_data = open("labels.txt", "r")

my_matrix = []
my_labels = []


def matrix_calculate(data):
    list1 = []
    for i in data:
        # subtracts punctuation
        i = i.strip("\n").strip("[").strip("]").replace(',', '')
        # Divides a row into integers and assigns it to an array
        x = [int(i) for i in i.split()]
        # Adds int array to matrix list
        list1.append(x)
    return list1


def mylist_print(list1):
    for line in list1:
        print(line)


def mylabel_strip(data):
    mylabels = []
    for line in data:
        mylabels = line.lstrip("(").lstrip('"').rstrip('"').rstrip(")").split(",")
    return mylabels



# smallest cell in the table
def lower(table):
    # Set 
    min = float("inf")
    x, y = -1, -1

    #  looking for the lowest
    for i in range(len(table)):
        for j in range(len(table[i])):
            if 0 < table[i][j] < min:
                min = table[i][j]
                x, y = i, j

    # Return 
    return x, y



#   two labels in a list 
def join(labels, a, b):
    #not ordered
    if b < a:
        a, b = b, a

    #  in the first index
    labels[a] = "(" + labels[a] + "," + labels[b] + ")"

    
    del labels[b]



#   entries of a table on the cell (a, b)
def join_table(table, a, b):
    #  not ordered
    if b < a:
        a, b = b, a

    # lower index,  (A, i),i < A
    row = []
    for i in range(0, a):
        row.append((table[a][i] + table[b][i]) / 2)
    table[a] = row

    #  the  column (i, A), i > A
    #    matrix is lower , row b only  values for indices < b
    for i in range(a + 1, b):
        table[i][a] = (table[i][a] + table[b][i]) / 2

    
    for i in range(b + 1, len(table)):
        table[i][a] = (table[i][a] + table[i][b]) / 2
        # ) second index entry
        del table[i][b]

   
    del table[b]



#   algorithm on a labelled table
def CALC(table, labels):
   
    while len(labels) > 1:
        #lowest cell in the table
        x, y = lower(table)

        # cell co-ordinates
        join_table(table, x, y)

        # Update 
        join(labels, x, y)

    # Return 
    return labels[0]



#   Makes labels  a starting
def alpha_labels(start, end):
    labels = []
    for i in range(ord(start), ord(end) + 1):
        labels.append(chr(i))
    return labels


# Test 
M_labels = alpha_labels("A", "G") 
M = [
    [],  # A
    [19],  # B
    [27, 31],  # C
    [8, 18, 26],  # D
    [33, 36, 41, 31],  # E
    [18, 1, 32, 17, 35],  # F
    [13, 13, 29, 14, 28, 12]  # G
]

d_matrix = matrix_calculate(matrix_data)

name_labels = mylabel_strip(labels_data)



print(CALC(d_matrix, name_labels))

