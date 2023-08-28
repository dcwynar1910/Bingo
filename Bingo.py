import random

def display_board(board):
    counter = 0
    
    for i in board:
        print(i,end=" ")
        
        counter += 1
        
        if counter == 5:
            print("\n",end = "")
            counter = 0

def vertical_check(board):
    for i in range(5):
        bingo = 0
        if board[i] == 1:
            step = i
            for j in range(5):
                
                if board[step+5] == 1:
                    #print("yes")
                    bingo += 1
                    step += 5
                else:
                    break

                if bingo == 4:
                    print("BINGO Vertically!!!")
                    return True #might not need True here
                
def horizontal_check(board):
    for i in range(0,21,5):
        bingo = 0
        if board[i] == 1:
            step = i
            for j in range(5):
                if board[step+1] == 1:
                    bingo += 1
                    step += 1
                else:
                    break

                if bingo == 4:
                    print("BINGO Horizontally!!!")
                    return True
                
def diagnonal_1(board):
    bingo = 0
    x = 0
    for i in range(5):
        
        if board[x] == 1:
            bingo += 1
            x += 6
        else:
            break

        if bingo == 5:
            print("BINGO Diagonally!!!")
            return True

def diagnonal_2(board):
    bingo = 0
    x = 0
    for i in range(5):
        
        if board[x] == 1:
            bingo += 1
            x += 4
        else:
            break

        if bingo == 5:
            print("BINGO Diagonally!!!")
            return True



picked = []
board = [0]*25
spaces = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25]

iteration = 1

for i in range(len(spaces)):
    rand = random.randrange(0,len(spaces))

    from_spaces = spaces.pop(rand)
    
    picked.append(from_spaces)

    board[(picked[-1])-1] = 1

    print("\nTurn: ", iteration, "\n")
    iteration += 1

    display_board(board)

    if vertical_check(board) or horizontal_check(board) or diagnonal_1(board) or diagnonal_2(board):
        break
    