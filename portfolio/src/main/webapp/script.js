// correct .js file

// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomFact() {
//   const greetings =
//       ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];
    const facts =
      ['I was on my school badminton team.', 
      'AP Computer Science A was one of my favorite subjects in high school :)', 
      'I like to sing.', 'I love volunteering to serve communities :)', 
    'Software Engineering was a career that I considered to pursue from my childhood itself :)'];

  // Pick a random fact.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

/** Fetches the current date from the server and adds it to the page. */

// Both the asynch fns: "showServerNoun" and "getServerMessages" are fetching 
// from the same webseervlet called "hello" from the servlet file. I commented out
// lines related to showServerNoun, so it doesn't show the hardcoded hello text 
// anymore. Instead both the fns point to the same random message json strings

// so is it possible to have both these fns work correctly even though they fetch
// from the same "hello" webservlet. or would i have to create a new/another
// webservlet to fetch from, for one of these fns.

async function showServerNoun() {
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();
  
    const dateContainer = document.getElementById('noun-container');
    dateContainer.innerText = textFromResponse;
}

/* Modify your JavaScript file to fetch the JSON list from the server. 
Confirm this works by printing it using the console.log() function. */

/** Fetches messages from the server and adds them to the page. */
async function getServerMessages() {
    const responseFromServer = await fetch('/hello');
    // The json() function returns an object that contains fields that we can
    // reference to create HTML.
    const myObject = await responseFromServer.json();
  
    const messagesListElement = document.getElementById('hello-container');
    messagesListElement.innerHTML = '';
  
    console.log(myObject);

    messagesListElement.appendChild(
        createListElement(myObject[Math.floor(Math.random() * myObject.messages.length)]));

    return messagesListElement;
  }
  
  /** Creates an <li> element containing text. */
  function createListElement(text) {
    const liElement = document.createElement('li');
    liElement.innerText = text;
    return liElement;
  }
