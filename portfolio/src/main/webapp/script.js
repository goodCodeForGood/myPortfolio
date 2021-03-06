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
async function showServerNoun() {
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();
  
    const dateContainer = document.getElementById('noun-container');
    dateContainer.innerText = textFromResponse;
}
