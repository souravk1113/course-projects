#solving suduko using backtracking
def check(n,x,y):
	global board
	for i in range(9):
		if board[x][i]==n:
			return False
		if board[i][y]==n:
			return False
	a=(x//3)*3
	b=(y//3)*3
	for i in range(a,a+3):
		for j in range(b,b+3):
			if board[i][j]==n:
				return False
	return True
def filled(n):
	for i in range(n):
		for j in range(n):
			if board[i][j]==0:
				return False
	return True
def nextempty(n):
	global board
	for x in range(n):
		for y in range(n):
			if board[x][y]==0:
				return (x,y) 
	return (-1,-1)
def display(n):
	global board
	for i in range(n):
		for j in range(n):
			print(board[i][j],end=" ")
		print()
def suduko(n,x,y):
	global board
	if x==-1:
		display(n)
		return True
	for k in range(1,n+1):
		if check(k,x,y):
			board[x][y]=k
			a,b=nextempty(n)
			if suduko(n,a,b):
				return True
				break
			else:
			    board[x][y]=0
	return False
board=    [[5,6,0,0,4,0,0,9,8], 
          [0,0,0,5,1,9,0,0,0], 
          [3,0,0,0,0,0,0,0,2], 
          [2,0,0,9,0,7,0,0,3], 
          [0,0,4,0,0,0,9,0,0], 
          [8,0,0,1,0,4,0,0,6], 
          [1,0,0,0,0,0,0,0,5], 
          [0,0,0,2,7,5,0,0,0], 
          [7,8,0,0,3,0,0,2,9]] 
print(suduko(9,0,2))
