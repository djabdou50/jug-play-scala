import 'dart:html';
import 'dart:async';

import 'package:mtp_jug/mtp_jug.dart';


void main() {
 
  String base = getServerBaseURL();

  addReverseTextSample();
  
  
  addWebSocketSample(base);  
 
}

addWebSocketSample(base) {
  new WebSocketSample(base);
}


addReverseTextSample() {
  query("#sample_text_id")
  ..text = "Click me!"
  ..onClick.listen(reverseText);
  
}

String getServerBaseURL() {
  String loc = document.window.location.toString();
  int i = loc.indexOf("/", 7);
  String base = loc.substring(7, i);
  if(base.indexOf("3030") != -1)
      base = "127.0.0.1:9000";
 // window.alert(base);
  return base;
}

void reverseText(MouseEvent event) {
  var text = query("#sample_text_id").text;
  var buffer = new StringBuffer();
  for (int i = text.length - 1; i >= 0; i--) {
    buffer.write(text[i]);
  }
  query("#sample_text_id").text = buffer.toString();
  

}




