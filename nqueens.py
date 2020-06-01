
def check(i,j,n):
	global board
	for x in range(n):
		if board[i][x]==1:
			return False
		if board[x][j]==1:
			return False
	for x in range(n):
		for y in range(n):
			if x+y==i+j and board[x][y]==1:
				return False
			if x-y==i-j and board[x][y]==1:
				return False
	return True

def display(board,n):
	for i in range(n):
		for j in range(n):
			print(board[i][j],end=" ")
		print()
	

def nqueens(n,row):
	global board
	if row==n:
		#print("good")
		display(board,n)
		print()
		#reset()
		#print(board)
		return True
	for i in range(n):
		#print("hello")
		if check(row,i,n):
			#print("yo",row,i)
			board[row][i]=1
			#print(board)
			if nqueens(n,row+1):
				board[row][i]=0
				
				continue
			else:
				board[row][i]=0
	return False
board=[]
for i in range(8):
	board.append([0]*8)
(nqueens(8,0))
