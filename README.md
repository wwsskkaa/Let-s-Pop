# Let-s-Pop
java game with accessibility

Copyright (c) | 2017 | Shuang Wu
 
# running instructions:
1. make sure ur java version is at least 1.8
2. javac *.class
3. java Main
4. enjoy!

# Description:
I believe you must have played Mahjong Solitaire before, but as a girl from China where real Mahjong was invented, I have to tell you the truth: real Mahjong is a gambling game which lots of Chinese are playing with their friends in entirely different way from Mahjong Solitaire's rules. Most importantly, since it is gambling, older generations don't really let younger generations touch it until they grow up.

However, how simple and engaging this game is makes it addicting: only goal is to remove every tile by matching pairs of identical tiles. Therefore I am creating a younger-generation-friendly game which is much simpler but still very fun, all you need to do is the match identical pairs of tiles. There are 4 different themes player can choose from:
1. "Nom Nom Nom" Food Theme
2. "Transformers" Transportation Theme
3. "Under the Sea" Sealife Theme
4. "Animal Kindom" Animal Theme
<p align="center">
  <img src="https://github.com/wwsskkaa/Lets-Pop/blob/master/screenshots/animal%20theme.png" width="200"/>
  <img src="https://github.com/wwsskkaa/Lets-Pop/blob/master/screenshots/food%20theme.png" width="200"/>
  <img src="https://github.com/wwsskkaa/Lets-Pop/blob/master/screenshots/transportation%20theme.png" width="200"/>
  <img src="https://github.com/wwsskkaa/Lets-Pop/blob/master/screenshots/sealife%20theme.png" width="200"/>
</p>

# Rules:
1) What is score: you will cummulate score every single match&pop happens, how much score you will get is based on how far and how many angle turns you have to make to connect the 2 tiles
2) What is potion: it is a magic potion you can use to reassemble the board when you don't have a clue what to do next. It will not change the tile pictures you have on ur board, and it will not give you extra tiles than you currently have left on the board. It will just reshuffle it. Every 5000 points you reach, you will get a potion. Once there is at least 1 option available, the bottom left corner potion button will be enabled so you can use it. But be careful: and everytime you use a magic potion, you will be deducted 5000 points too.
3) How do we match and pop: first, the picture on the tile has to match, then, imagine you can only make 90 degree turns in drawing a path from 2 tiles, if you can make no more than 2 turns to connect the 2, then you can pop it. Of course, the tiles next to each other can be popped if they have same picture.
4) Nothing will be saved after you quit the game.
5) "New game" button is different from "Potion" button, New game will give you a entirely new game with new tile images and it will fill up the entire board to full for you to play. However, new game will not make your last game's score disappear. Once you finish a game by popping everything out, click New game to keep playing!

# Accessibility:
I have been adding accessibility for some parts of a website my internship company works on now. It is surprising to see how many users actually use Tab and Enter than use Mouse. That's why I decided to make every thing on the game board able to be selected using Tab and there will be a light blue rim around the tile to show you which one is chosen. If you want to select a tile, simple press Enter. It is that simple!

# Ongoing development:
It is something I have been developing outside of my internship workhours. And I am planning to add the features below to this:
1)Adding more themes, I am obsessed with Toy Story so I want to do a Toy Story Theme with the character emojis that I designed by myself.
2)Adding sound effects, such as "under the sea" background music for the sealife theme.
3)Adding a learning mode, such as instead of having 2 tiles of same tiger to match on the board, I can have one with Tiger picture and one with word "Tiger", so kids can enjoy learning vocabulary for animals, sealife, transportation tools and food.
4)Adding levels: expanding the board, adding a countdown time bar, add other magic potions to give hints or add more time.

# Picture Credit:
http://www.flaticon.com/packs/gastronomy-set
http://www.flaticon.com/free-icon/dog_235405
http://www.flaticon.com/free-icon/fish_146713
http://www.flaticon.com/packs/sea-life-collection
