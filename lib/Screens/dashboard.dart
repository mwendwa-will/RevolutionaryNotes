import 'package:flutter/material.dart';
import 'package:revelotionarynotes/Screens/login.dart';

class Notes {
  Notes(this.title, this.content);
  String title;
  String content;
}

class Dashboard extends StatefulWidget {
  const Dashboard({super.key});

  @override
  State<Dashboard> createState() => _DashboardState();
}

class _DashboardState extends State<Dashboard> {
  final List<Notes> _notes = [
    Notes('Meeting Notes', 'Discuss the new project requirements.'),
    Notes('Grocery List', 'Milk, Bread, Eggs, Butter, and Cheese.'),
    Notes('Homework', 'Complete the math assignment and science project.'),
    Notes('Workout Plan', 'Monday: Cardio, Tuesday: Strength Training.'),
    Notes('Travel Itinerary', 'Visit Paris, Rome, and Barcelona in July.'),
    Notes('Book List', 'Read "The Great Gatsby" and "To Kill a Mockingbird".'),
    Notes('Shopping List', 'Buy a new phone, headphones, and a laptop.'),
    Notes('Recipe', 'Pancakes: Flour, Milk, Eggs, Sugar, and Baking Powder.'),
    Notes('Daily Goals', 'Meditate, Exercise, and Read for 30 minutes.'),
    Notes('Birthday Plan', 'Organize a surprise party and buy a gift.'),
  ];

  void _addNote() async {
    final newNote = await Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => AddNoteScreen()),
    );

    if (newNote != null) {
      setState(() {
        _notes.add(newNote);
      });
    }
  }

  void _removeNoteAt(int index) {
    setState(() {
      _notes.removeAt(index);
    });
  }

  void _editNote(int index) async {
    final editedNote = await Navigator.push(
      context,
      MaterialPageRoute(
          builder: (context) => AddNoteScreen(
              title: _notes[index].title, content: _notes[index].content)),
    );
    if (editedNote != null) {
      setState(() {
        _notes[index] = editedNote;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Notes'),
      ),
      drawer: _buildNavigationDrawer(context),
      body: LayoutBuilder(
        builder: (context, constraints) {
          return ListView.builder(
            itemCount: _notes.length,
            itemBuilder: (context, index) {
              final note = _notes[index];
              return Padding(
                padding: const EdgeInsets.all(8.0),
                child: Dismissible(
                  key: UniqueKey(),
                  direction: DismissDirection.endToStart,
                  onDismissed: (direction) {
                    final removedNote = _notes[index];
                    setState(() {
                      _removeNoteAt(index);
                    });
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text('${removedNote.title} dismissed'),
                        action: SnackBarAction(
                          label: 'Undo',
                          onPressed: () {
                            setState(() {
                              _notes.insert(index, removedNote);
                            });
                          },
                        ),
                      ),
                    );
                  },
                  background: Container(
                    color: Colors.red,
                    alignment: Alignment.centerRight,
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: const Icon(Icons.delete, color: Colors.white),
                  ),
                  child: GestureDetector(
                    onTap: () {
                      _editNote(index);
                    },
                    child: SizedBox(
                      width: MediaQuery.sizeOf(context).width,
                      child: Card(
                        elevation: 4,
                        child: Padding(
                          padding: const EdgeInsets.all(16.0),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                note.title,
                                style: const TextStyle(
                                  fontSize: 18,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                              const SizedBox(height: 8),
                              Text(note.content),
                            ],
                          ),
                        ),
                      ),
                    ),
                  ),
                ),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _addNote,
        tooltip: 'Add Note',
        child: const Icon(Icons.add),
      ),
    );
  }
}

Widget _buildNavigationDrawer(BuildContext context) {
  return Drawer(
    child: ListView(
      padding: EdgeInsets.zero,
      children: <Widget>[
        const DrawerHeader(
          decoration: BoxDecoration(
            color: Colors.yellow,
          ),
          child: Text(
            'Menu',
            style: TextStyle(
              color: Colors.black,
              fontSize: 24,
            ),
          ),
        ),
        ListTile(
          leading: const Icon(Icons.note),
          title: const Text('Notes'),
          onTap: () {
            Navigator.pop(context);
            // Navigate to Notes screen or handle action
          },
        ),
        ListTile(
          leading: const Icon(Icons.settings),
          title: const Text('Settings'),
          onTap: () {
            Navigator.pop(context);
            // Navigate to Settings screen or handle action
          },
        ),
        const Divider(),
        ListTile(
          leading: const Icon(Icons.logout),
          title: const Text('Logout'),
          onTap: () {
            Navigator.pushReplacement(context,
                MaterialPageRoute(builder: (context) => const Login()));
            // Handle logout
          },
        ),
      ],
    ),
  );
}

class AddNoteScreen extends StatefulWidget {
  final String? title;
  final String? content;

  AddNoteScreen({this.title, this.content});

  @override
  _AddNoteScreenState createState() => _AddNoteScreenState();
}

class _AddNoteScreenState extends State<AddNoteScreen> {
  late TextEditingController _titleController;
  late TextEditingController _contentController;

  @override
  void initState() {
    super.initState();
    _titleController = TextEditingController(text: widget.title ?? '');
    _contentController = TextEditingController(text: widget.content ?? '');
  }

  void _saveNote() {
    final title = _titleController.text;
    final content = _contentController.text;

    if (title.isNotEmpty && content.isNotEmpty) {
      final editedNote = Notes(title, content);
      Navigator.pop(context, editedNote);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Add Note'),
        actions: [
          IconButton(
            icon: const Icon(Icons.save),
            onPressed: _saveNote,
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _titleController,
              decoration: const InputDecoration(labelText: 'Title'),
            ),
            const SizedBox(height: 16),
            TextField(
              controller: _contentController,
              decoration: const InputDecoration(
                  labelText: 'Content', border: InputBorder.none),
              maxLines: 5,
            ),
            const SizedBox(height: 16),
          ],
        ),
      ),
    );
  }
}
