# this is for practicing some basic python functions

def subsetsWithDup(S):
    S.sort()
    res = set()
    res.add(())
    for elem in S:
        res.add(tuple(subset) + (elem,) for subset in tuple(res))
    return [[*subset] for subset in res]

res = subsetsWithDup([1,2,2,3,3,4])
print(res)