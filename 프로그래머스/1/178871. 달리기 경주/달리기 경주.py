def solution(players, callings):
    hash_map = {}
    for i, player in enumerate(players):
        hash_map[player] = i
        
    for name in callings:
        idx = hash_map[name]
        hash_map[name] -= 1
        hash_map[players[idx - 1]] += 1
        players[idx - 1], players[idx] = players[idx], players[idx - 1]
    
    
    return players