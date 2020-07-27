'''
cache 与 Database 互动
'''

class UserService:
    def getUser(self, user_id):
        key = 'user::%s' % user_id
        user = cache.get(user)
        if user:
            return user

        user = database.get(user_id)
        cache.set(key, user)
        return user

    def setUser(self, user):
        key = 'user::%s' % user.id
        database.set(user)
        cache.delete(key)
