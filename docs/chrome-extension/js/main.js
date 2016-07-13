chrome.app.runtime.onLaunched.addListener(function(launchData) {
  chrome.app.window.create('index.html', {id:"temp", innerBounds: {width: 1024, height: 758}}, function(win) {
    win.contentWindow.launchData = launchData;
  });
});