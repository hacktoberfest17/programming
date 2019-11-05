dictionary = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9, 'k': 10, 'l': 11, 'm': 12,
              'n': 13, 'o': 14, 'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19, 'u': 20, 'v': 21, 'w': 22, 'x': 23,
              'y': 24, 'z': 25, ' ': 26, '?': 27, '.': 28}
CONST_SIZE = 29


def get_matrix(word, key_d):
    matrix = []
    size = len(word)
    s_list = [dictionary[word[0]]]
    for i in range(1, size):
        index = dictionary[word[i]]
        if i % key_d != 0:
            s_list.append(index)
        else:
            matrix.append(s_list)
            s_list = [dictionary[word[i]]]
    matrix.append(s_list)
    return matrix

'''
    Function for String Encryption
'''
def encrypt(f_key, plain_mat):
    rows = len(plain_mat)
    cols = len(plain_mat[0])
    # print (str(rows) + " " + str(cols))
    rows_key = len(f_key)
    enc_msg = []
    for it in range(0, rows):
        row_value = []
        for j in range(0, cols):
            val = 0
            for k in range(0, rows_key):
                # print(str(plain_mat[it][j]) + " " + str(f_key[k][j]))
                val += (plain_mat[it][k] * f_key[k][j])
            row_value.append(val % CONST_SIZE)
        enc_msg.append(row_value)
    return enc_msg

'''
    Function for Getting Required Vakues from Dictionary
'''
def get_val_from_dict(num):
    for char, code in dictionary.items():
        if code == num:
            return char
    return ''


def get_string(matrix):
    string = ""
    cols = len(matrix[0])
    rows = len(matrix)
    for i in range(0, rows):
        for j in range(0, cols):
            # print(matrix[j][i])
            string += (get_val_from_dict(matrix[i][j]))
    return string


# Decryption Code Starts Here
def initialize(l):
    mat = []
    for i in range(0, l):
        row = []
        for j in range(0, l):
            row.append(0)
        mat.append(row)
    return mat


def egcd(a, b):
    if a == 0:
        return b, 0, 1
    else:
        g, y, x = egcd(b % a, a)
        return g, x - (b // a) * y, y


def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m


def get_co_factor(mat, p, q, n):
    size = n
    temp = []
    for i in range(0, size):
        if i != p:
            if q == 0:
                list_t = mat[i][q + 1:size]
                # print(mat[i])
            else:
                list_t = mat[i][0: q] + mat[i][q + 1:size]
                # print(mat[i][0, q])
            temp.append(list_t)
    return temp


def determinant(matrix, size):
    val = 0
    if size == 1:
        return matrix[0][0]
    sign = 1
    for i in range(0, size):
        temp = get_co_factor(matrix, 0, i, size)
        val += sign * matrix[0][i] * determinant(temp, size - 1)
        sign = -sign
    return val


def ad_joint(matrix):
    rows = len(matrix)
    cols = len(matrix[0])
    adj = []
    if rows == 1 and cols == 1:
        adj.append([1])
        return adj
    adj = initialize(rows)
    for i in range(0, rows):
        for j in range(0, cols):
            temp = get_co_factor(matrix, i, j, rows)
            if (i + j) % 2 == 0:
                sign = 1
            else:
                sign = -1
            adj[j][i] = sign * determinant(temp, cols - 1)
    return adj


def inverse_of_matrix(adjoint, size, det):
    inverse_mat = []
    for i in range(0, size):
        inverse_row = []
        for j in range(0, size):
            val = (det * adjoint[i][j]) % CONST_SIZE
            inverse_row.append(val)
        inverse_mat.append(inverse_row)
    return inverse_mat


def get_inverse(given_mat, size):
    adjoint_of_mat = ad_joint(given_mat)
    # print(adjoint_of_mat)
    determinant_mat = determinant(given_mat, size)
    # print(determinant_mat % CONST_SIZE)
    mul_inverse_tuple = modinv(determinant_mat % CONST_SIZE, CONST_SIZE)
    inverse_mat = inverse_of_matrix(adjoint_of_mat, size, mul_inverse_tuple)
    # print("Inverse of Matrix")
    return inverse_mat


def decrypt(f_key, plain_mat):
    rows = len(plain_mat)
    cols = len(plain_mat[0])
    # print (str(rows) + " " + str(cols))
    rows_key = len(f_key)
    enc_msg = []
    for it in range(0, rows):
        row_value = []
        for j in range(0, cols):
            val = 0
            for k in range(0, rows_key):
                # print(str(plain_mat[it][j]) + " " + str(f_key[k][j]))
                val += (plain_mat[it][k] * f_key[k][j])
            row_value.append(val % CONST_SIZE)
        enc_msg.append(row_value)
    return enc_msg


# Main Code Starts Here
# Get the size of matrix
key_size = int(input())
key = []
# Get the matrix From Input
for itr in range(0, key_size):
    r_vals = list(map(int, input().split()))
    key.append(r_vals)
inverse_key = get_inverse(key, key_size)
# print(inverse_key)
# print(key)
t = int(input())

while t > 0:
    line = input()
    # e stands for encryption See INPUT Format Below
    if line[0] == 'e':
        plaintext = line[2:]
        while len(plaintext) % key_size != 0:
            plaintext += 'x'
        # print(plaintext)
        plain_matrix = get_matrix(plaintext, key_size)
        # print(plain_matrix)
        encrypted_value = encrypt(key, plain_matrix)
        # print(encrypted_value)
        encryped_string = get_string(encrypted_value)
        print("Encrypted String:" + encryped_string)
    # d stands for decryption See INPUT Format Below
    elif line[0] == 'd':
        ciphertext = line[2:]
        cipher_matrix = get_matrix(ciphertext, key_size)
        # print(cipher_matrix)
        decrypted_value = decrypt(inverse_key, cipher_matrix)
        decrypted_string = get_string(decrypted_value)
        # print(decrypted_value)
        print("Decrypted String: " + decrypted_string)
    t -= 1
'''
3
21 18 19
17 3 7
5 2 28
2
e hi. how are you?
d rdqkyhfkuewgbvmavn'
'''