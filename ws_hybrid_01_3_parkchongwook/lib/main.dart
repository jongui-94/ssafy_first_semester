import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter WS_Day1'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  // int _counter = 0;
  //
  // void _incrementCounter() {
  //   setState(() {
  //     _counter++;
  //   });
  // }
  String _ctText = "SSAFY";

  void _pressButton() {
    setState(() {
      if(_ctText == "SSAFY") {
        _ctText = "SSAFY MOBILE TRACK 화이팅!!";
      }
      else {
        _ctText = "SSAFY";
      }

    });
  }

  void _pressButton2() {
    setState(() {
      if(_ctText == "SSAFY MOBILE TRACK 화이팅!!"){
        _ctText = "구미 6반 만세";
      }
      else {
        _ctText = "SSAFY";
      }

    });
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(

        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            // const Text(
            //   'You have pushed the button this many times:',
            // ),
            Text(
              //'$_counter',
              '$_ctText',
              style: const TextStyle(color: Colors.orange, fontSize: 30)
            ),
            ElevatedButton(onPressed: _pressButton2, child: const Icon(Icons.print))
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _pressButton,
        tooltip: 'longpressed~',
        child: const Icon(Icons.touch_app),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
