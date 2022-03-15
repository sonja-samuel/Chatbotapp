import { Component, OnDestroy, OnInit } from '@angular/core';
import { WebSocketAPI } from '../../_services/WebSocketAPI';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.scss']
})
export class ChatbotComponent implements OnInit,OnDestroy {
    title = 'springboot websocket';

    webSocketAPI: WebSocketAPI;
    message: any;
    messageArray=[];
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
        this.webSocketAPI._send(data);
        this.messageArray.push({name:'you',message:message})
      }
    
      handleMessage(message){
        console.log("received from:" ,message);
          this.messageArray.push({name:'bot',message:message})

          
          
        // this.message = message;
      }

      ngOnDestroy(): void {
          this.disconnect();
      }

     
    }