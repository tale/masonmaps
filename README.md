# CS321 Project

To run frontend:
Install nodejs from [here](https://nodejs.org) and select the LTS version (left green button)

Once it is installed, open your terminal and ensure that `npm` runs successfully on it.
It should print something like this:
```
npm <command>

Usage:

npm install        install all the dependencies in your project
npm install <foo>  add the <foo> dependency to your project
npm test           run this project's tests
npm run <foo>      run the script named <foo>
npm <command> -h   quick help on <command>
npm -l             display usage info for all commands
npm help <term>    search for help on <term>
npm help npm       more involved overview

All commands:
```

Then in order to run the frontend, you'll need to navigate into the frontend folder from your terminal by doing `cd frontend/`.
Once there, run `npm install`, it will install all dependencies and once that is done, run `npm run dev` which should start the server.
It should say it's running on `http://localhost:5173`, just navigate to this URL on your browser.

Once done, editing any file in the `frontend/src` folder will automatically reload the frontend with your changes!

To run backend:
Install Java 17 (idk how you are supposed to do this).
Then you need to cd into the backend folder `cd backend/` and run the following command based on computer.

Windows: `gradlew.bat bootRun`
Linux/macOS: `./gradlew bootRun`

It should setup everything and start the server on port 8080.
When you make changes, you'll need to do Ctrl+C in the terminal and run the command again to restart the server.
