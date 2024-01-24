# [level 2] 택배 배달과 수거하기 - 150369 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/150369?language=python3) 

### 성능 요약

메모리: 11.6 MB, 시간: 20.94 ms

### 구분

코딩테스트 연습 > 2023 KAKAO BLIND RECRUITMENT

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 1월 3일 16:30:27

### 문제 설명

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7ce63a07-3abd-40a1-87cc-c1f664393aa0/%E1%84%8C%E1%85%A2%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8B%E1%85%AD%E1%86%BC%20%E1%84%90%E1%85%A2%E1%86%A8%E1%84%87%E1%85%A2%20%E1%84%89%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A1.png" title="" alt="재할용 택배 상자.png"></p>

<p>당신은 일렬로 나열된 <code>n</code>개의 집에 택배를 배달하려 합니다. 배달할 물건은 모두 크기가 같은 재활용 택배 상자에 담아 배달하며, 배달을 다니면서 빈 재활용 택배 상자들을 수거하려 합니다. <br>
배달할 택배들은 모두 재활용 택배 상자에 담겨서 물류창고에 보관되어 있고, <code>i</code>번째 집은 물류창고에서 거리 <code>i</code>만큼 떨어져 있습니다. 또한 <code>i</code>번째 집은 <code>j</code>번째 집과 거리 <code>j - i</code>만큼 떨어져 있습니다. (1 ≤ <code>i</code> ≤ <code>j</code> ≤ <code>n</code>) <br>
트럭에는 재활용 택배 상자를 최대 <code>cap</code>개 실을 수 있습니다. 트럭은 배달할 재활용 택배 상자들을 실어 물류창고에서 출발해 각 집에 배달하면서, 빈 재활용 택배 상자들을 수거해 물류창고에 내립니다. 각 집마다 배달할 재활용 택배 상자의 개수와 수거할 빈 재활용 택배 상자의 개수를 알고 있을 때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하려 합니다. <strong>각 집에 배달 및 수거할 때, 원하는 개수만큼 택배를 배달 및 수거할 수 있습니다.</strong></p>

<p>다음은 <code>cap</code>=4 일 때, 최소 거리로 이동하면서 5개의 집에 배달 및 수거하는 과정을 나타낸 예시입니다. </p>

<p><strong>배달 및 수거할 재활용 택배 상자 개수</strong> </p>
<table class="table">
        <thead><tr>
<th></th>
<th>집 #1</th>
<th>집 #2</th>
<th>집 #3</th>
<th>집 #4</th>
<th>집 #5</th>
</tr>
</thead>
        <tbody><tr>
<td>배달</td>
<td>1개</td>
<td>0개</td>
<td>3개</td>
<td>1개</td>
<td>2개</td>
</tr>
<tr>
<td>수거</td>
<td>0개</td>
<td>3개</td>
<td>0개</td>
<td>4개</td>
<td>0개</td>
</tr>
</tbody>
      </table>
<p><strong>배달 및 수거 과정</strong></p>
<table class="table">
        <thead><tr>
<th></th>
<th>집 #1</th>
<th>집 #2</th>
<th>집 #3</th>
<th>집 #4</th>
<th>집 #5</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/3</td>
<td>3/0</td>
<td>1/4</td>
<td>2/0</td>
<td>물류창고에서 택배 3개를 트럭에 실어 출발합니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/3</td>
<td>3/0</td>
<td><strong>0</strong>/4</td>
<td><strong>0</strong>/0</td>
<td>물류창고에서 5번째 집까지 이동하면서(거리 5) 4번째 집에 택배 1개를 배달하고, 5번째 집에 택배 2개를 배달합니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/3</td>
<td>3/0</td>
<td>0/<strong>0</strong></td>
<td>0/0</td>
<td>5번째 집에서 물류창고까지 이동하면서(거리 5) 4번째 집에서 빈 택배 상자 4개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 4개를 트럭에 싣습니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td><strong>0</strong>/0</td>
<td>0/3</td>
<td><strong>0</strong>/0</td>
<td>0/0</td>
<td>0/0</td>
<td>물류창고에서 3번째 집까지 이동하면서(거리 3) 1번째 집에 택배 1개를 배달하고, 3번째 집에 택배 3개를 배달합니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>0/0</td>
<td>0/<strong>0</strong></td>
<td>0/0</td>
<td>0/0</td>
<td>0/0</td>
<td>3번째 집에서 물류창고까지 이동하면서(거리 3) 2번째 집에서 빈 택배 상자 3개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내립니다.</td>
</tr>
</tbody>
      </table>
<p>16(=5+5+3+3)의 거리를 이동하면서 모든 배달 및 수거를 마쳤습니다. 같은 거리로 모든 배달 및 수거를 마치는 다른 방법이 있지만, 이보다 짧은 거리로 모든 배달 및 수거를 마치는 방법은 없습니다. </p>

<p>트럭에 실을 수 있는 재활용 택배 상자의 최대 개수를 나타내는 정수 <code>cap</code>, 배달할 집의 개수를 나타내는 정수 <code>n</code>, 각 집에 배달할 재활용 택배 상자의 개수를 담은 1차원 정수 배열 <code>deliveries</code>와 각 집에서 수거할 빈 재활용 택배 상자의 개수를 담은 1차원 정수 배열 <code>pickups</code>가 매개변수로 주어집니다. 이때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>cap</code> ≤ 50</li>
<li>1 ≤ <code>n</code> ≤ 100,000</li>
<li><code>deliveries</code>의 길이 = <code>pickups</code>의 길이 = <code>n</code>

<ul>
<li><code>deliveries[i]</code>는 i+1번째 집에 배달할 재활용 택배 상자의 개수를 나타냅니다.</li>
<li><code>pickups[i]</code>는 i+1번째 집에서 수거할 빈 재활용 택배 상자의 개수를 나타냅니다. </li>
<li>0 ≤ <code>deliveries</code>의 원소 ≤ 50</li>
<li>0 ≤ <code>pickups</code>의 원소 ≤ 50</li>
</ul></li>
<li>트럭의 초기 위치는 물류창고입니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>cap</th>
<th>n</th>
<th>deliveries</th>
<th>pickups</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>4</td>
<td>5</td>
<td>[1, 0, 3, 1, 2]</td>
<td>[0, 3, 0, 4, 0]</td>
<td>16</td>
</tr>
<tr>
<td>2</td>
<td>7</td>
<td>[1, 0, 2, 0, 1, 0, 2]</td>
<td>[0, 2, 0, 1, 0, 2, 0]</td>
<td>30</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>문제 예시와 동일합니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<p><strong>배달 및 수거할 재활용 택배 상자 개수</strong> </p>
<table class="table">
        <thead><tr>
<th></th>
<th>집 #1</th>
<th>집 #2</th>
<th>집 #3</th>
<th>집 #4</th>
<th>집 #5</th>
<th>집 #6</th>
<th>집 #7</th>
</tr>
</thead>
        <tbody><tr>
<td>배달</td>
<td>1개</td>
<td>0개</td>
<td>2개</td>
<td>0개</td>
<td>1개</td>
<td>0개</td>
<td>2개</td>
</tr>
<tr>
<td>수거</td>
<td>0개</td>
<td>2개</td>
<td>0개</td>
<td>1개</td>
<td>0개</td>
<td>2개</td>
<td>0개</td>
</tr>
</tbody>
      </table>
<p><strong>배달 및 수거 과정</strong></p>
<table class="table">
        <thead><tr>
<th></th>
<th>집 #1</th>
<th>집 #2</th>
<th>집 #3</th>
<th>집 #4</th>
<th>집 #5</th>
<th>집 #6</th>
<th>집 #7</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/2</td>
<td>2/0</td>
<td>0/1</td>
<td>1/0</td>
<td>0/2</td>
<td>2/0</td>
<td>물류창고에서 택배 2개를 트럭에 실어 출발합니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/2</td>
<td>2/0</td>
<td>0/1</td>
<td>1/0</td>
<td>0/2</td>
<td><strong>0</strong>/0</td>
<td>물류창고에서 7번째 집까지 이동하면서(거리 7) 7번째 집에 택배 2개를 배달합니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/2</td>
<td>2/0</td>
<td>0/1</td>
<td>1/0</td>
<td>0/<strong>0</strong></td>
<td><strong>0</strong>/0</td>
<td>7번째 집에서 물류창고까지 이동하면서(거리 7) 6번째 집에서 빈 택배 상자 2개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/2</td>
<td><strong>1</strong>/0</td>
<td>0/1</td>
<td><strong>0</strong>/0</td>
<td>0/0</td>
<td>0/0</td>
<td>물류창고에서 5번째 집까지 이동하면서(거리 5) 3번째 집에 택배 1개를 배달하고, 5번째 집에 택배 1개를 배달합니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>1/0</td>
<td>0/<strong>1</strong></td>
<td>1/0</td>
<td>0/<strong>0</strong></td>
<td>0/0</td>
<td>0/0</td>
<td>0/0</td>
<td>5번째 집에서 물류창고까지 이동하면서(거리 5) 4번째 집에서 빈 택배 상자 1개를 수거하고 2번째 집에서 빈 택배 상자 1개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td><strong>0</strong>/0</td>
<td>0/1</td>
<td><strong>0</strong>/0</td>
<td>0/0</td>
<td>0/0</td>
<td>0/0</td>
<td>0/0</td>
<td>물류창고에서 3번째 집까지 이동하면서(거리 3) 1번째 집에 택배 1개를 배달하고, 3번째 집에 택배 1개를 배달합니다.</td>
</tr>
<tr>
<td>남은 배달/수거</td>
<td>0/0</td>
<td>0/<strong>0</strong></td>
<td>0/0</td>
<td>0/0</td>
<td>0/0</td>
<td>0/0</td>
<td>0/0</td>
<td>3번째 집에서 물류창고까지 이동하면서(거리 3) 2번째 집에서 빈 택배 상자 1개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내립니다.</td>
</tr>
</tbody>
      </table>
<p>30(=7+7+5+5+3+3)의 거리를 이동하면서 모든 배달 및 수거를 마쳤습니다. 같은 거리로 모든 배달 및 수거를 마치는 다른 방법이 있지만, 이보다 짧은 거리로 모든 배달 및 수거를 마치는 방법은 없습니다. <br>
따라서, 30을 return 하면 됩니다.</p>

## 내 풀이 방법
```
while(index){
        if(index에 0보다 큰 값이 있으면){
                해당 index를 move에 더함
                for(index; index--;;){
                        cap 용량이 넘치기 전까지 처리
                        cap 용량 넘친 경우, index를 여기로 업데이트하고 break
                }
        }
}
```
deliveries, pickup 배열을 뒤에서 탐색하며 0보다 큰 게 하나라도 있으면 해당 index를 들르기 <br/>
그 index로부터 남은 cap 용량만큼 빼면서 배열을 뒤에서 탐색<br/>
용량을 넘칠 경우 그 index로 업데이트 후 break <br/>
```python
    def solution(cap, n, deliveries, pickups):
    move = 0
    idx = n-1
    while(idx>=0):
        if deliveries[idx] > 0 or pickups[idx] > 0:
            move+=idx+1
            count_del = 0
            count_pick = 0
            for i in range(idx, -1, -1):
                delivery = min(cap-count_del, deliveries[i])
                deliveries[i] -= delivery
                count_del += delivery
                pick = min(cap-count_pick, pickups[i])
                pickups[i] -= pick
                count_pick += pick
                if count_del > cap or count_pick > cap:
                    idx = i
                    break
        else:
            idx -= 1
    return move*2
```



#### 틀린 이유: 시간 초과
#### 시간초과의 원인: deliveries, pickups 배열에 작은 개수의 박스들이 놓여 있는 경우, 루프를 많이 돌아서 시간 초과가 나는 것으로 생각
#### 해결방법: Java로 언어를 바꿔서 제출해보았음에도 시간초과가 나길래, 언어 문제가 아닌 내 로직에 문제가 있다고 생각하고 그냥 해답 검색합.

## 해답
옮길 수 있는 양을 delivery, pickup 각각 카운트하는 변수를 선언<br/>
각 배열을 뒤에서 탐색하면서 배열의 값을 각 카운트 변수에 ADD<br/>
카운트한 변수가 0보다 크다면 그 인덱스에는 들러야 한다는 뜻<br/>
그 인덱스에 들러서 카운트 변수에 각각 다시 cap만큼 SUB<br/>


```python
def solution(cap, n, deliveries, pickups):
    move = 0
    del_pool = 0
    pick_pool = 0
    for i in range(n-1, -1, -1):
        del_pool += deliveries[i]
        pick_pool += pickups[i]
        while del_pool > 0 or pick_pool > 0:
            del_pool -= cap
            pick_pool -= cap
            move += i+1
    return move*2
```






> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
