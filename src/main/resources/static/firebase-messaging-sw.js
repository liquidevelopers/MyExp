importScripts('https://www.gstatic.com/firebasejs/3.9.0/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/3.9.0/firebase-messaging.js');

// Initialize the Firebase app in the service worker by passing in the
// messagingSenderId.
firebase.initializeApp({
   'messagingSenderId': '122669793957'
});

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
const messaging = firebase.messaging();

messaging.setBackgroundMessageHandler(function(payload) {
  console.log('[firebase-messaging-sw.js] Received background message ', payload);
  // Customize notification here
  /*const notificationTitle = 'Incoming Call...';
  const notificationOptions = {
    body: 'payload',
    icon: '/itwonders-web-logo.png'
  };*/

  return self.registration.showNotification(payload.data.title,
		  {
	    body: payload.data.body
	    
	    /*icon: payload.data.icon,
	    tag: payload.data.tag,
	    data: payload.data.link*/
	  });
});
