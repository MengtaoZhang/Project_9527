forward_queue = 所有起点
backward_queue = 所有终点
forward_set = 标记所有起点访问过
backward_set = 标记所有终点访问过

distance = 0
while forward_queue 和 back_queue 非空
    distance++
    for 所有forward_queue 里的点
        拓展出下一层节点加入 forward_queue 并在 forward_set 里标记
        如果有在 backward_set 出现则 return distance
    
    distance++
    for 所有 backward_queue 里的点
        拓展出下一层节点加入 backward_queue 并在 backward_set 里标记
        如果有在 forward_set 出现则 return distance