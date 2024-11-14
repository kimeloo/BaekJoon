import sys

class cal_set():
    def __init__(self):
        self.myset = set()
    
    def add(self, x):
        self.myset.add(x)
    
    def remove(self, x):
        self.myset.discard(x)
    
    def isin(self, x):
        return 1 if x in self.myset else 0
    
    def check(self, x):
        print(self.isin(x))

    def toggle(self, x):
        if self.isin(x):
            self.remove(x)
        else:
            self.add(x)
    
    def all(self, dummy):
        self.myset = set(i for i in range(1,21))
    
    def empty(self, dummy):
        self.myset = set()

def main():
    n = int(sys.stdin.readline().strip())
    myset = cal_set()

    cmds = {
        'add': myset.add,
        'remove': myset.remove,
        'check': myset.check,
        'toggle': myset.toggle,
        'all': myset.all,
        'empty': myset.empty
    }

    for _ in range(n):
        inp = sys.stdin.readline().split()
        cmd = inp[0]
        x = int(inp[1] if len(inp)>1 else 0)
        cmds[cmd](x)
    
if __name__ == '__main__':
    main()