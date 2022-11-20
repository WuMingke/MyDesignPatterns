package com.erkuai.mydesignpatterns

class Dp11 {
    // 用了抽象工厂模式的数据库访问
    fun test() {
        val user = User()
        val dept = Department()

        val factory: IFactory1 = AccessFactory() // 只需要确定实例化哪一个数据库访问对象给factory
        val iu: IUser = factory.createUser()
        iu.insert(user)
        iu.getUser(1)

        val department: IDepartment = factory.createDepartment()
        department.insert(dept)
        department.getDepartment(1)
    }
}

class Department {
    private var id = 0
    private var name = ""
}

class User {
    private var id = 0
    private var name = ""
}

/**
 * 用户客户端访问，解除与具体数据库访问的耦合
 */
interface IDepartment {
    fun insert(department: Department)
    fun getDepartment(id: Int): Department?
}

class SqlServerDepartment : IDepartment {
    override fun insert(department: Department) {
    }

    override fun getDepartment(id: Int): Department? {
        return null
    }
}

class AccessDepartment : IDepartment {
    override fun insert(department: Department) {
    }

    override fun getDepartment(id: Int): Department? {
        return null
    }
}

interface IUser {
    fun insert(user: User)
    fun getUser(id: Int): User?
}

class SqlServerUser : IUser {
    override fun insert(user: User) {
    }

    override fun getUser(id: Int): User? {
        return null
    }

}

class AccessUser : IUser {
    override fun insert(user: User) {
    }

    override fun getUser(id: Int): User? {
        return null
    }
}

interface IFactory1 {
    fun createUser(): IUser
    fun createDepartment(): IDepartment
}

class SqlServerFactory : IFactory1 {
    override fun createUser(): IUser {
        return SqlServerUser()
    }

    override fun createDepartment(): IDepartment {
        return SqlServerDepartment()
    }

}

class AccessFactory : IFactory1 {
    override fun createUser(): IUser {
        return AccessUser()
    }

    override fun createDepartment(): IDepartment {
        return AccessDepartment()
    }

}
