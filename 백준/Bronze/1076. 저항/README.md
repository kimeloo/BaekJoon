# [Bronze II] 저항 - 1076 

[문제 링크](https://www.acmicpc.net/problem/1076) 

### 성능 요약

메모리: 14372 KB, 시간: 104 ms

### 분류

구현

### 제출 일자

2026년 1월 6일 00:55:35

### 문제 설명

<p style="user-select: auto !important;">전자 제품에는 저항이 들어간다. 저항은 색 3개를 이용해서 그 저항이 몇 옴인지 나타낸다. 처음 색 2개는 저항의 값이고, 마지막 색은 곱해야 하는 값이다. 저항의 값은 다음 표를 이용해서 구한다.</p>

<table class="table table-bordered table-center-30" style="user-select: auto !important;">
	<thead style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<th style="width: 10%; user-select: auto !important;">색</th>
			<th style="width: 10%; user-select: auto !important;">값</th>
			<th style="width: 10%; user-select: auto !important;">곱</th>
		</tr>
	</thead>
	<tbody style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">black</td>
			<td style="user-select: auto !important;">0</td>
			<td style="user-select: auto !important;">1</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">brown</td>
			<td style="user-select: auto !important;">1</td>
			<td style="user-select: auto !important;">10</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">red</td>
			<td style="user-select: auto !important;">2</td>
			<td style="user-select: auto !important;">100</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">orange</td>
			<td style="user-select: auto !important;">3</td>
			<td style="user-select: auto !important;">1,000</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">yellow</td>
			<td style="user-select: auto !important;">4</td>
			<td style="user-select: auto !important;">10,000</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">green</td>
			<td style="user-select: auto !important;">5</td>
			<td style="user-select: auto !important;">100,000</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">blue</td>
			<td style="user-select: auto !important;">6</td>
			<td style="user-select: auto !important;">1,000,000</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">violet</td>
			<td style="user-select: auto !important;">7</td>
			<td style="user-select: auto !important;">10,000,000</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">grey</td>
			<td style="user-select: auto !important;">8</td>
			<td style="user-select: auto !important;">100,000,000</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="user-select: auto !important;">white</td>
			<td style="user-select: auto !important;">9</td>
			<td style="user-select: auto !important;">1,000,000,000</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto !important;">예를 들어, 저항의 색이 yellow, violet, red였다면 저항의 값은 4,700이 된다.</p>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에 첫 번째 색, 둘째 줄에 두 번째 색, 셋째 줄에 세 번째 색이 주어진다. 위의 표에 있는 색만 입력으로 주어진다.</p>

### 출력 

 <p style="user-select: auto !important;">입력으로 주어진 저항의 저항값을 계산하여 첫째 줄에 출력한다.</p>

