import heapq
import os
from functools import total_ordering

@total_ordering
class HuffmanNode:

    """Huffman tree node subclass, has the constructor and comparing functions
    Attributes:
        ch (str): character inside the node
        freq (int): frequence of appearence of the character
        left_child (HuffmanNode): left child of the node
        right_child (HuffmanNode): right child of the node
    """
    def __init__(self, ch, freq):
        self.ch = ch
        self.freq = freq
        self.left_child = None
        self.right_child = None

    # less than method
    def __lt__(self, other):
        return self.freq < other.freq

    # equals method
    def __eq__(self, other):
        if(other == None):
            return False
        if(not isinstance(other, HuffmanNode)):
            return False
        return self.freq == other.freq


class Huffman:

    """Huffman Tree class, with the compressing and decompressing methods
    Attributes:
        code_mapping (dict): reverse mapping for the huffman codes
        filepath (str): path of the targeted file
        heap (list): the Huffman tree itself implemented as a heap
        huff_codes (dict): dictionary containing the code for each character
    """
    def __init__(self, filepath):
        self.filepath = filepath
        self.heap = []
        self.huff_codes = {}
        self.code_mapping = {}

    def make_frequency_dict(self, text):
        freq = {}  # creates a new dictionary
        for ch in text:  # for each character in text
            if not ch in freq:  # if it is not in the frequency dict create it
                freq[ch] = 0
            freq[ch] += 1  # increases frequency of character 'ch'
        return freq

    def make_heap(self, freq):
        for key in freq:
            node = HuffmanNode(key, freq[key])
            heapq.heappush(self.heap, node)

    def merge_nodes(self):
        while len(self.heap) > 1:
            # pops first two leaves
            n1 = heapq.heappop(self.heap)
            n2 = heapq.heappop(self.heap)

            # creates a new node merging the popped nodes,
            # and assigns them as left and right child
            merged_node = HuffmanNode(None, n1.freq + n2.freq)
            merged_node.left_child = n1
            merged_node.right_child = n2

            # push the merged node to the heap
            heapq.heappush(self.heap, merged_node)

    def _make_codes(self, root, code):
        # root is empty
        if root == None:
            return
        # root has a character (is not a merged node)
        if root.ch != None:
            # maps the code to the code dict
            self.huff_codes[root.ch] = code
            # stores the reverse mapping
            self.code_mapping[code] = root.ch
            return

        # recursive call to the left  and right side,
        # if it is a lef child, it will get a 0 appended on its code,
        # if it is a right child, it will get a 1 appended on its code
        self._make_codes(root.left_child, code + '0')
        self._make_codes(root.right_child, code + '1')

    def make_codes(self):
        root = heapq.heappop(self.heap)  # gets the root of the heap
        code = ''  # initial code
        self._make_codes(root, code)  # calls the helper function

    def get_encoded_text(self, text):
        encoded_text = ''
        # for each character, append its
        # huffman code to the encoded text
        for ch in text:
            encoded_text += self.huff_codes[ch]
        return encoded_text

    def pad_encoded_text(self, encoded_text):
        """Inserts padding in the encoded text for binary conversion
        Args:
            encoded_text (str): the encoded text
        Returns:
            str: encoded text with the padding
        """
        extra_padding = 8 - len(encoded_text) % 8
        for i in range(extra_padding):
            encoded_text += '0'
        padded_info = '{0:08b}'.format(extra_padding)
        encoded_text = padded_info + encoded_text
        return encoded_text

    def get_byte_array(self, padded_encoded_text):
        if len(padded_encoded_text) % 8 != 0:
            print("Encoded text not padded properly")
            exit(0)

        b = bytearray()
        for i in range(0, len(padded_encoded_text), 8):
            byte = padded_encoded_text[i:i+8]
            b.append(int(byte, 2))
        return b

    def compress(self):
        filename, file_ext = os.path.splitext(self.filepath)
        output_file = filename + '.bin'

        print("Compression process started.\n" +
              "The uncompressed file has: {} bytes".format(
                  os.path.getsize(self.filepath)
              ))

        with open(self.filepath, 'r+') as f, open(output_file, 'wb') as out:
            text = f.read()
            text = text.rstrip()

            character_frequency = self.make_frequency_dict(text)
            self.make_heap(character_frequency)
            self.merge_nodes()
            self.make_codes()

            enc_text = self.get_encoded_text(text)
            padded_enc_text = self.pad_encoded_text(enc_text)

            b = self.get_byte_array(padded_enc_text)
            out.write(bytes(b))

        print("Compression process finished.\n" +
              "The compressed file has: {} bytes".format(
                  os.path.getsize(output_file)
              ))
        return output_file

    def remove_padding(self, padded_encoded_text):
        padded_info = padded_encoded_text[:8]
        extra_padding = int(padded_info, 2)
        padded_encoded_text = padded_encoded_text[8:]
        encoded_text = padded_encoded_text[:-1*extra_padding]

        return encoded_text

    def decode_text(self, encoded_text):
        code = ''
        decoded_text = ""

        for bit in encoded_text:
            code += bit
            if code in self.code_mapping:
                ch = self.code_mapping[code]
                decoded_text += ch
                code = ''
        return decoded_text

    def decompress(self, in_path):
        filename, file_ext = os.path.splitext(self.filepath)
        output_file = filename + '_decompressed.txt'

        print("Starting decompression process")

        with open(in_path, 'rb') as f, open(output_file, 'w') as out:
            bit_string = ''
            byte = f.read(1)
            while byte != '':
                byte = ord(byte)
                bits = bin(byte)[2:].rjust(8, '0')
                bit_string += bits
                byte = f.read(1)

            encoded_text = self.remove_padding(bit_string)
            decompressed_text = self.decode_text(encoded_text)
            out.write(decompressed_text)
        print("Decompression process finished")
        return output_file

# run this function to test the algorithm
def main():
    # edit this file path to use a different file
    file_path = "./austinpowers.txt"

    huff = Huffman(file_path) # creates a new instance of huffman tree
    output_file = huff.compress() # compress the file
    huff.decompress(output_file) # decompress the file in a lossless form

if __name__ == '__main__':
    main()
