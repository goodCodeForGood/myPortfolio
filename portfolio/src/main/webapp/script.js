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

function addRandomFact() {
    const facts =
      ['I was on my school badminton team.', 
      'AP Computer Science A was one of my favorite subjects in high school :)', 
      'I like to sing.', 'I love volunteering to serve communities :)', 
    'Software Engineering was a career that I considered to pursue from my childhood itself :)'];

  const fact = facts[Math.floor(Math.random() * facts.length)];
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

async function showServerNoun() {
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();
  
    const dateContainer = document.getElementById('noun-container');
    dateContainer.innerText = textFromResponse;
}

async function getServerMessages() {
    const responseFromServer = await fetch('/hello');
    const myObject = await responseFromServer.json();
  
    const messagesListElement = document.getElementById('hello-container');
    messagesListElement.innerHTML = '';
  
    console.log(myObject.text);

    messagesListElement.appendChild(
        createListElement(myObject[Math.floor(Math.random() * myObject.messages.length)]));

    return messagesListElement;
  }

  async function getRandomServerText() {
    const responseFromServer = await fetch('/hello');
    const myObject = await responseFromServer.json();
  
    const messagesListElement = document.getElementById('hello-container');
    messagesListElement.innerHTML = '';
  
    console.log(myObject.text);

    messagesListElement.appendChild(
        createListElement(myObject.text[Math.floor(Math.random() * myObject.text.length)]));
  }
  
  function createListElement(text) {
    const liElement = document.createElement('li');
    liElement.innerText = text;
    return liElement;
  }

  function requestTranslation() {
      // instead of .getElementById('text').value, use .getElementById('text').innerText becuase
      // this element "does not have a "value" attribute"
    const text = document.getElementById('text').innerText;
    const languageCode = document.getElementById('language').innerText; // same here

    const resultContainer = document.getElementById('result');
    resultContainer.innerText = 'Loading...';

    const params = new URLSearchParams();
    params.append('text', text);
    params.append('languageCode', languageCode);

    fetch('/translation-handler', {
      method: 'POST',
      body: params
    }).then(response => response.text())
    .then((translatedMessage) => {
      resultContainer.innerText = translatedMessage;
    });
  }