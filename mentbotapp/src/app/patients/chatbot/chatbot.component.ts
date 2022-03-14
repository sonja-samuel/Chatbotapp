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
    messageArray:any;
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
        this.webSocketAPI._send(message);
      }
    
      handleMessage(message){
        this.message = message;
      }
      ngOnDestroy(): void {
          this.disconnect();
      }
    }