import argparse

def cli_parser():
    """ parses command line input """
    parser_main = argparse.ArgumentParser(prog='')
    parser_main.add_argument("--infasta",
                             help="path to the raw fasta",
                             required = True)
    parser_main.add_argument("--reversefasta",
                             help="path to the filtered fasta",
                             required = True)

    args = parser_main.parse_args()
    return args

def make_seq_dict(args):
    seq_dict = dict()
    ok = dict.fromkeys("GATC")
    with open(args.infasta, "r") as handle:
        for line in handle.readlines():
            a = line.rstrip()
            if a.startswith(">"):
                key = str(a)
                seq_dict[key] = str()
            elif all(c in ok for c in a):
                seq_dict[key] += str(a)
            else:
                continue
    return seq_dict

def complement_seq(seq, tdict):
    compl = str()
    for c in seq[::-1]:
        compl += tdict[c]
    return compl

def translate_seq_dict(seq_dict):
    tdict= { "A" : "T",
             "T" : "A",
             "G" : "C",
             "C" : "G"
           }
    tl_seq_dict = dict.fromkeys(seq_dict.keys())
    for key in tl_seq_dict.keys():
        tl_seq_dict[key] = complement_seq(seq=seq_dict[key], tdict=tdict)

    return tl_seq_dict

def write_fasta(args, seq_dict):
    with open(args.reversefasta, "w") as handle:
        for key in seq_dict.keys():
            handle.write(key+"\n")
            handle.write(seq_dict[key]+"\n")

def main():
    args = cli_parser()
    sd = make_seq_dict(args)
    td = translate_seq_dict(sd)
    write_fasta(args, td)

if __name__ == '__main__':
    main()
