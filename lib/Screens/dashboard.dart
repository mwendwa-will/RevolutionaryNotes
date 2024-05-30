import 'package:flutter/material.dart';

class Dashboard extends StatefulWidget {
  const Dashboard({super.key});

  @override
  State<Dashboard> createState() => _DashboardState();
}

class _DashboardState extends State<Dashboard> {
  List<Notes> _getNotes() {
    final List<Notes> notes = <Notes>[];
    notes.addAll([
      Notes('Meeting Notes', 'Discuss the new project requirements.'),
      Notes('Grocery List', 'Milk, Bread, Eggs, Butter, and Cheese.'),
      Notes('Homework', 'Complete the math assignment and science project.'),
      Notes('Workout Plan', 'Monday: Cardio, Tuesday: Strength Training.'),
      Notes('Travel Itinerary', 'Visit Paris, Rome, and Barcelona in July.'),
      Notes(
          'Book List', 'Read "The Great Gatsby" and "To Kill a Mockingbird".'),
      Notes('Shopping List', 'Buy a new phone, headphones, and a laptop.'),
      Notes('Recipe', 'Pancakes: Flour, Milk, Eggs, Sugar, and Baking Powder.'),
      Notes('Daily Goals', 'Meditate, Exercise, and Read for 30 minutes.'),
      Notes('Birthday Plan', 'Organize a surprise party and buy a gift.'),
    ]);
    return notes;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Notes'),
      ),
      body: LayoutBuilder(
        builder: (context, constraints) {
          return ListView.builder(
            itemCount: _getNotes().length,
            itemBuilder: (context, index) {
              return Padding(
                padding: const EdgeInsets.all(8.0),
                child: Card(
                  elevation: 4,
                  child: Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          _getNotes()[index].title,
                          style: const TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        const SizedBox(height: 8),
                        Text(_getNotes()[index].content),
                      ],
                    ),
                  ),
                ),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        tooltip: 'Add Note',
        child: const Icon(Icons.add),
      ),
    );
  }
}

class Notes {
  Notes(this.title, this.content);
  String title;
  String content;
}
