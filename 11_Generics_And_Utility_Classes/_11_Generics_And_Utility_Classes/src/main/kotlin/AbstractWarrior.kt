//Свойства:

//Методы:
//
//Атаковать (метод интерфейса) — если патронов в оружии нет, перезарядить оружие и пропустить ход.
// В противном случае получить патроны для выстрела. Для каждого из них проверить,
// соответствует ли патрон точности война и уклонению противника.
// Для патронов, которые попадают в противника, рассчитать суммарный урон. Нанести урон врагу.
//Понести урон (метод интерфейса) — отнять от текущего уровня здоровья урон.
abstract class AbstractWarrior : Warrior {
    abstract var maxHealth: Int
    abstract var health: Int
    abstract var luckyPossibility: Int
    abstract var accuracy: Int
    abstract var weapon: AbstractWeapon
    abstract var name: String
}