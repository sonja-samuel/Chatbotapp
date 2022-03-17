import { Component, OnDestroy, OnInit } from '@angular/core';
import { WebSocketAPI } from '../../_services/WebSocketAPI';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.scss']
})
export class ChatbotComponent implements OnInit,OnDestroy {
    title = 'springboot websocket';

    webSocketAPI: WebSocketAPI;
    message: any;
    messageArray=[
      {name: "you", message: "hello1"},
      {name: "bot", message: "hello2"},
      {name: "you", message: "hello3"},
      {name: "bot", message: "hello4"},
      {name: "you", message: "hello5"},
      {name: "you", message: "hello6"},
    ];
    name: string;
    ngOnInit() {
      this.webSocketAPI = new WebSocketAPI(new ChatbotComponent());
      this.connect();
     
    }
  
    connect(){
      this.webSocketAPI._connect();
    }
  
    disconnect(){
      this.webSocketAPI._disconnect();
    }
    sendMessage(message){
       let data = {};
       data['message'] = message;
       this.messageArray.push({name:"you",message:message})
        this.webSocketAPI._send(data);
        
      }
    
      handleMessage(message){
        console.log("received from:" ,message);
          this.messageArray.push({name:"bot",message:message})

        //   console.error(this.messageArray);
          
        // this.message = message;
      }

      ngOnDestroy(): void {
          this.disconnect();
      }

     
    }