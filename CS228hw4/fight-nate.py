import os

win_rate = 0
for_range = int(input("How many times do you want this to run? "))
system_count = input("How many systems do you want in each test? ")
for i in range(0, for_range):
        os.system("java -jar galaxycommander.jar C:\\Users\\haadi\\Dropbox\\CS228hw4\\out\\production\\CS228_HW4\\cs228hw4\\game\\MyAgent.class C:\\Users\\haadi\\Downloads\\MyAgent.class random " + system_count + " -grading > test.txt")
        blue_count = 0
        red_count = 0
#        print(win_rate)
        with open("test.txt") as f:
            lines = f.readlines()
            for j in range(len(lines) - int(system_count), len(lines)):
                if ": Blue" in lines[j]:
                    blue_count += 1
                elif ": Red" in lines[j]:
                    red_count += 1
        print("Your score: " + str(blue_count))
        if blue_count > red_count:
            win_rate += 1
print("The win rate is: " + str(win_rate / for_range * 100) + "%")
