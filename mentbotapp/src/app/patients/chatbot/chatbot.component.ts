import { Component, OnDestroy, OnInit } from "@angular/core";
import { WebSocketAPI } from "../../_services/WebSocketAPI";
import { NgForm } from "@angular/forms";
import { AppsocketService } from "../../_services/appsocket.service";

@Component({
  selector: "app-chatbot",
  templateUrl: "./chatbot.component.html",
  styleUrls: ["./chatbot.component.scss"],
})
export class ChatbotComponent implements OnInit, OnDestroy {
  title = "springboot websocket";

  // webSocketAPI: WebSocketAPI;
  message : any;
  messageArray = [];
  name: string;

  constructor(private appSocket:AppsocketService){}
  ngOnInit() {
    this.appSocket.returnMessage.subscribe({
      next: (v) => this.handleMessage(v)
    });
    // this.webSocketAPI = new WebSocketAPI(new ChatbotComponent());
    this.connect();
  }

  connect() {
    this.appSocket._connect();
  }

  disconnect() {
    this.appSocket._disconnect();
  }
  sendMessage() {
    let data = {};
    data["message"] = this.message;
    this.messageArray.push({ name: "you:", message: this.message });
    this.appSocket._send(data);
    console.log(this.messageArray);
    this.message = '';
  }

  handleMessage(message) {
    console.log("received from:", message);
    this.messageArray.push({ name: "bot:", message: message });
    console.log(this.messageArray);
  }

  ngOnDestroy(): void {
    this.disconnect();
  }
}
