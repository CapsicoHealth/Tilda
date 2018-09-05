# poc-chrome-extension

## Installation/Running

### Prerequisites
 * **[NodeJS](http://nodejs.org/)**

### Running on a device or simulator
Installing node/bower dependencies (both locally and globally for node):

```
cd <cloned directory>
npm install
export PATH="$(npm bin):$PATH"
bower install
```

## Running extension
  * **[Enable developer mode](https://developer.chrome.com/extensions/faq#faq-dev-01)** in google-chrome/chromium brower and 'load unpacked extention' -(point to)-> output directory.