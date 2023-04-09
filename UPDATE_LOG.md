# UPDATE LOG

## v0.3.0

### :rotating_light:注意：由于新地形和多石头的加入，该版本中的gameHelper()指令正在开发中，请勿使用该指令！否则会报错！

### 新增

#### 指令

- ##### putRock()    用石头填平面前一格的陷阱

  效果如图：

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409143423966.png" alt="image-20230409143423966" style="zoom:50%;" />

##### 异常判定

1. 背包内有石头但面前一格没有陷阱

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409143626739.png" alt="image-20230409143626739" style="zoom:50%;" />

2. 背包内没有石头

   <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409144021021.png" alt="image-20230409144021021" style="zoom:50%;" />

   

- ##### noRockPresent() 检测面前一格是否有石头，没有则输出true，否则输出false

  效果如图：

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409144321162.png" alt="image-20230409144321162" style="zoom:50%;" />

  

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409144443725.png" alt="image-20230409144443725" style="zoom:50%;" />



- ##### noRockInBag()  检测背包内是否有石头，没有则输出true，否则输出false

  效果如图：

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409145534550.png" alt="image-20230409145534550" style="zoom:50%;" />

  

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409145602304.png" alt="image-20230409145602304" style="zoom:50%;" />

#### 地图

- ##### STAGE3

  ![image-20230409150058341](C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409150058341.png)

#### 地图标记

- ##### 陷阱 

  在地图上显示为⊙，若踩中陷阱或是试图穿过陷阱，则会落入陷阱并使游戏失败

  ![image-20230409150427237](C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409150427237.png)

- ##### 填平的陷阱

  放入石头后，陷阱会变为填平的陷阱，在地图上显示为×，踩中或是穿过填平的陷阱将不再使游戏失败

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409150715028.png" alt="image-20230409150715028" style="zoom:50%;" />

### 改进

- 将类分开存储到单独的文件后，反射机制终于生效了！现在 getCommand() 方法可以根据指令名动态地获取对应指令类的实例，而不再需要使用分支语句。这使代码大幅简化，也使可扩展性大幅增加，可喜可贺。
- 统一了 placeObject() 的实现逻辑，使Avatar类不再需要覆盖该方法，而是直接在改变方向时设置对应的custom。
- 使用加载配置文件的方法来初始化地图，现在更改地图只需要更改resources目录下对应的配置文件，更为便捷和安全，也使制作地图编辑器，导入/导出地图等操作更为方便。

### TODO

- 完善GameHelper()方法，使其适配有陷阱和多石头的情况。
- 加入地图编辑器，使制作地图，移植地图更为方便。



## v0.2.0

### 新增

#### 指令

- ##### move(int x)    向当前方向移动 x 步

  效果如图：

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401211156419.png" alt="image-20230401211156419" style="zoom:50%;" />

当括号内没有参数时，将采用默认值1，即move()效果等同于move(1):

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401212120206.png" alt="image-20230401212120206" style="zoom:50%;" />

##### 异常判定

1. 移动超出边界：

   <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401211556569.png" alt="image-20230401211556569" style="zoom:50%;" />

2. 移动到不可达地块：

   <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401211740730.png" alt="image-20230401211740730" style="zoom:50%;" />

3. 移动受阻

   <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401211852651.png" alt="image-20230401211852651" style="zoom:50%;" />



- ##### pickRock()  拾取面前的一块石头并放入背包

  效果如图：

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401212544910.png" alt="image-20230401212544910" style="zoom:50%;" />

##### 异常判定

​	面前一格不是石头：

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401212649269.png" alt="image-20230401212649269" style="zoom:50%;" />



- ##### showInformation() 给出以下信息：地图上剩余石头数量、背包内石头数量、距离最近的石头有几格

​	效果如图：

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401213015234.png" alt="image-20230401213015234" style="zoom:50%;" />



<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401213118259.png" alt="image-20230401213118259" style="zoom:50%;" />



- ##### *gameHelper()  提供一条到达石头的路径（不一定最短）*

  效果如图：

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401213615928.png" alt="image-20230401213615928" style="zoom:50%;" />

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401213705609.png" alt="image-20230401213705609" style="zoom:50%;" />

  **注意：该指令目前尚未适配多石头的情况，功能将在之后的更新中完善**

#### 地图

- ##### STAGE1

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401213933341.png" alt="image-20230401213933341" style="zoom:50%;" />

- ##### STAGE2

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401214006281.png" alt="image-20230401214006281" style="zoom:50%;" />

若输入STAGE3或NEWMAP，则会输出提示语并提示重新选关：

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401214132777.png" alt="image-20230401214132777" style="zoom:50%;" />

#### 地图标记

- ##### 石头 

  在地图上显示为 ● ，不可穿越，可被拾取，拾取后石头变为地面，拾取所有石头后游戏胜利

  <img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401212649269.png" alt="image-20230401212649269" style="zoom:50%;" />

- ##### 墙壁

  在地图上显示为 ■ ，不可穿越，不可拾取

<img src="C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230401211852651.png" alt="image-20230401211852651" style="zoom:50%;" />

### 改进

- 重写了大部分提示语，使其更加幽默风趣。

- 将move(int x)的实现逻辑优化为执行 x 次move(1)，并在每次执行后判断移动是否合法，比起一开始直接设置坐标的实现逻辑，这样做避免了通过不可穿越地块。

- 增加了 MapObject 类，并将之前的 Avatar 类与新增的 rock（石头）、wall（墙壁）和path（gameHelper指令给出的路径）类设置为 MapObject 类的子类，使它们继承方法 placeObject() ，并在不同子类的构造函数里调用 setCustom() 方法为不同实例设置不同的custom类型，如石头的 custom 是'●'，这样如果以后还有新的地图标记，只需要将其设置为 MapObject 的子类使其继承方法 placeObject() ，并在构造函数里调用setCustom() 方法设置对应的 custom 就可以了。

  *注意：Avatar 类需要覆盖 placeObject(), 因为当角色方向不同时custom也不同，需要用分支语句进行判断（或许以后可以在改变方向时设置对应的 custom 以达成统一）*

- 简化了 Avatar 类中 placeObject() 的实现逻辑，使本不该由它完成的部分（如判断移动是否合法）移动到了应该出现的位置，即移动逻辑的实现中。

- 简化了移动是否合法的判定，由于有多种不可达地块，如石头、墙壁，一开始使用了大量的与逻辑来判定移动是否合法；现在在 Map 类中创建了一个记录所有可移动地块的列表，只需判断目标地块是否包含于这个列表中即可，如果以后有更多的不可达地块加入，无需更改代码，若是新增了可移动地块，也只需扩充列表即可。

  *注：或许以后可以通过类型来判断是否可达，而不是像现在通过字符类型的比较来判断。*
