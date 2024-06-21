'''
딕셔너리 생성 -> 키:값에서, 컴퓨터번호:연결된번호목록
1 2와 같이 연결된 한 쌍이 주어질 때, 
1:[2]
2:[1] 동시에 추가

최초 타겟을 시작으로, 딕셔너리에 저장된 값 목록의 컴퓨터를 queue에 입력
queue를 제거해나가며 모든 연결된 컴퓨터 숫자 세기
이미 지나간 경우를 별도 list에 저장하거나 해당 키의 값을 [ ]로 만들어주어 skip
'''

import sys
from collections import deque

def add_to_network():
    _network = dict()
    for _ in range(k):
        curr, next = map(int, sys.stdin.readline().split())

        if curr not in _network:     # 딕셔너리에 curr이 존재하지 않으면
            _network[curr] = []      # curr의 값으로 빈 리스트 저장
        if next not in _network:     # 딕셔너리에 next가 존재하지 않으면 
            _network[next] = []      # next의 값으로 빈 리스트 저장
        _network[curr].append(next)  # curr에 해당하는 리스트에 next 추가
        _network[next].append(curr)  # next에 해당하는 리스트에 curr 추가

    return _network
    
def count(first, _network):
    counter = -1
    q = deque()

    q.append(first)
    while q:
        curr = q.popleft()              # 다음 탐색할 지점을 curr에 저장
        if curr not in network:         # curr이 network에 없는 경우 continue
            continue
        elif network[curr][0] == 0:     # 이미 탐색한 경우 continue
            continue
        
        for next in _network[curr]:     # curr 다음으로 탐색할 지점을 q에 추가
            q.append(next)
        _network[curr] = [0]            # curr을 이미 탐색했다는 표시 생성
        counter += 1

    counter = max(counter, 0)           # 1번 컴퓨터와 연결된 컴퓨터가 없는 경우, counter==-1이므로 0으로 조정

    return counter



if __name__ == '__main__':
    n = int(sys.stdin.readline().strip())
    k = int(sys.stdin.readline().strip())
    
    network = add_to_network()        # 각 컴퓨터와 연결된 컴퓨터 list를 network 딕셔너리에 저장
    
    print(count(1, network))