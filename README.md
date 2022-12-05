# 🦈xharkTank-Backend
Backend application for a platform based on the concept of Shark Tank, where businesses can post their pitches while investors put counter offers on it. 
## Overview
Built this project as part of PhonePe's Tech Scholars Program.
## Technology Stack
* Java 11
* MongoDB 4.2
* SpringBoot 2.7.6
* Maven 3.8.6
### Testing Technology Stack
* Python (pytests)
* Shell
## API EndPoints
* GET --> /pitches
* GET --> /pitches/<pitch_id>
* POST --> /pitches
* POST --> /pitches/<pitch_id>/makeOffer

![image](https://user-images.githubusercontent.com/58912231/204361023-d7a38d3e-bf1e-4bcb-83e4-80e4f769381e.png)

## Architecture
### Overall
<image src = "https://user-images.githubusercontent.com/58912231/204363014-2b86356d-75ea-485a-87dc-cd21953d715c.png" width =600 height = 300/>

### Backend
Used MVC Architecture to implement the backend side:

![image](https://user-images.githubusercontent.com/58912231/204363920-46d20bf0-0f24-442d-bab8-ef4c9a183f40.png)

## Setup
### Overall
1. Start MongoDB server by using the following commands in cmd:
```
C:\>cd \Program Files\MongoDB\Server\4.2\bin
C:\Program Files\MongoDB\Server\4.2\bin>mongod
```
This should start the server in port 27017

2. Set up proper SDKs and JREs in your IDE according to your java version

### Test Cases
* Leave the assessment directory untouched for proper execution of test cases.
* Open your terminal/command prompt, let’s install the required dependencies by executing the following command. Make sure you have Python 3 and pip3 installed on your local machine: 

```
pip3 install -r assessment/requirements.txt
python3 -m pytest --pspec --disable-pytest-warnings assessment/main.py
```
You should see something like this:
![image](https://user-images.githubusercontent.com/58912231/204366346-7f06810c-ea80-4b53-a98a-146c020c0863.png)



