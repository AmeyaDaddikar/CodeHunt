# CodeHunt
#### The official CodeHunt app for the event, brought to you by Community of Coders


## About CodeHunt
CodeHunt is an in-campus treasure hunt competition for the F.Y. students, conducted by the [Community of Coders](https://www.facebook.com/CommunityOfCoders/). 
The goal of this competition is to encourage interaction amongst the students across various departments, and to introduce them to the field of coding and development, and to provide a glimpse of the activities and the aim behind the Community Of Coders.


The competition has teams of two students working together, to solve a given set of questions using logic, team-work and use of online resources. Every question has a designated location assigned in the college. After solving a particular question, the participating team is provided with a clue to the location of the next question. The first team to solve all the questions win!!!

## About the App
The CodeHunt uses an Android Application built on the recently released [Android Studio 3.0](https://developer.android.com/studio/index.html). The main objective of the app is to keep a track of the progress of the participating team on the app itself. The app replaces the previously used chit-based system, which was used to ensure that the teams follow the sequence of the questions pre-determined, and also ensure that the participants don't skip  any questions.

<img src="https://github.com/AmeyaDaddikar/CodeHunt/blob/master/screenshot2.png" width = "300px">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/AmeyaDaddikar/CodeHunt/blob/master/screenshot1.png" width = "300px">

### The basic working of the App
1. The team arrives at a location.
2. The volunteer sees the team's app, and verifies if the team is supposed to be on that location. If not, then the team is sent back.
3. The team is given the question to solve.
4. The team solves the question and gets the clue to the next location.
5. The team calls the volunteer. The volunteer puts a pin into the app, which moves the App state to the next question.
6. The team goes to the next location.

### FAQs
##### 1. Does the app need any internet connection to work?
No, the app stores the Question State internally in the phone itself.
##### 2. What if the app crashes, or is closed while the competition is ongoing?
The current question is saved in the app data, and the app renders the menu screen based on this stored value.
##### 3. What format is this data saved in ?
We use SharedPreferences to save the current question the team is at. To learn more about shared preferences, [click me](https://developer.android.com/training/data-storage/shared-preferences.html#GetSharedPreferences).
##### 4. Can we compare the timing for every participating teams? Is there any leader board system implemented in the App?
Unfortunately no. Due to the short time constraint on the app development, we had to reside onto offline data saving solutions, and using time was not a reliable solution. We are looking forward towards improving, and would be happy to include such features in our future events.

We, at the Community Of Coders, believe that a strong community helps its participants to learn and explore the new technologies and techniques. We too, are learning at the moment, and the journey of developing this was taught us a lot. Projects like these really expose you to a lot of new stuff, with challenges set throughout the way. We encourage you to take upon yourself such challenges, learn something new, create something new. Hope to see you soon, as a shinning member of the Community of Coders. ; ) 
