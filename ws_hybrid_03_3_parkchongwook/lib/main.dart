import 'package:flutter/material.dart';
import 'package:ws_hybrid_03_3_parkchongwook/shape.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter WS_Day3',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter WS_Day3'),
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

  var _textX = TextEditingController();
  var _textY = TextEditingController();

  String _ctMessage = "결과값: ";

  void _calculate() {
    int x = int.parse(_textX.text);
    int y = int.parse(_textY.text);
    var calcSquare = CalcSquare(x, y);
    setState(() {
      _ctMessage = "연산결과 x = $x,y = $y \n 거리: ${calcSquare.distanceTo(calcSquare)}, \n 넓이: ${calcSquare.getArea()}";
    });

  }

  @override
  void dispose() {
    _textX.dispose();
    _textY.dispose();
    super.dispose();
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
            const Text(
              '거리 & 사각형 면적 계산하기',
              style: TextStyle(
                fontSize: 25,
                fontStyle: FontStyle.italic,
                fontWeight: FontWeight.bold,
                color: Colors.black
              ),
            ),
            TextField(
              controller: _textX,
            ),
            TextField(
              controller: _textY,
            ),
            Text(
              '$_ctMessage',
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _calculate,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
