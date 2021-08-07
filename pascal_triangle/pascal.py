class Triangle(object):
  def __init__(self, *args, **kwargs):
    self.rows = [[1]]
  
  def make_rows(self, count):
    if count > len(self.rows):
      for i in range(len(self.rows), count):
        self.__append_row()

  def __append_row(self):
    row_no = len(self.rows) + 1
    prev_row = self.rows[-1]
    new_row = map(lambda i: prev_row[i] + prev_row[i+1],range(row_no - 2))
    self.rows.append([1] + list(new_row) + [1])

  def pretty_print(self):
    last_row = self.rows[-1]
    full_width = len(last_row)
    for row in self.rows:
      padding = full_width - len(row)
      print("\t" * padding, end='')
      print('\t\t'.join(str(i) for i in row), end='')
      print("\t" * padding)

if __name__ == "__main__":
  triangle = Triangle()
  triangle.make_rows(5)
  triangle.pretty_print()
