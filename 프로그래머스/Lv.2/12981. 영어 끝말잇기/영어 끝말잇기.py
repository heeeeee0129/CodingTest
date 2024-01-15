def solution(n, words):
    prev_char = words[0][-1]
    prev_words = {words[0]}
    turn = 1
    number = 0
    for i in range(1, len(words)):
        number = (number+1)%n
        if number == 0: turn+=1
        word = words[i]
        if (word[0] != prev_char) or (word in prev_words):
            return [number+1, turn]
        prev_char = word[-1]
        prev_words.add(word)
    return [0,0]
        