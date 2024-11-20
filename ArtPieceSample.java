/*********************************/
/* Please do not edit this class */
/* Content change without notify */
/*********************************/

public class ArtPieceSample extends javax.swing.JFrame {
    private java.util.Map _stateMap;
    private Recognized_as_unrepairableTransition _damaged_State_recognized_as_unrepairableTransition = new Recognized_as_unrepairableTransition("recognized as unrepairable", new String[] {}, new Class[] {});
    private Exhibition_endsTransition _on_show_exhibition_endsTransition = new Exhibition_endsTransition("exhibition ends", new String[] {}, new Class[] {});
    private Auction_day_arrivesTransition _in_waitlist_for_auction_auction_day_arrivesTransition = new Auction_day_arrivesTransition("auction day arrives", new String[] {}, new Class[] {});
    private Authenticated_to_have_valueTransition _out_side_of_collection_authenticated_to_have_valueTransition = new Authenticated_to_have_valueTransition("authenticated to have value", new String[] {}, new Class[] {});
    private DamagedTransition _in_the_art_collection_damagedTransition = new DamagedTransition("damaged", new String[] {}, new Class[] {});
    private Exhibition_day_arrivesTransition _in_waitlist_for_exhibition_exhibition_day_arrivesTransition = new Exhibition_day_arrivesTransition("exhibition day arrives", new String[] {}, new Class[] {});
    private Not_soldTransition _on_auction_not_soldTransition = new Not_soldTransition("not sold", new String[] {}, new Class[] {});
    private SoldTransition _on_auction_soldTransition = new SoldTransition("sold", new String[] {}, new Class[] {});

    private javax.swing.JTextField _currentState;
    private javax.swing.JButton _processButton;
    private javax.swing.JTextArea _log;
    private javax.swing.ButtonGroup _optionGroup;
    private javax.swing.JComponent _optionPane;

    private ArtPiece _artPiece;
    private Transition _selectedTransition;

    public ArtPieceSample() {
        _stateMap = new java.util.HashMap();
        _stateMap.put(ArtPieceContext.ArtPieceFSM.In_storage, new Transition[] {});
        _stateMap.put(ArtPieceContext.ArtPieceFSM.Damaged_State, new Transition[] { _damaged_State_recognized_as_unrepairableTransition });
        _stateMap.put(ArtPieceContext.ArtPieceFSM.On_show, new Transition[] { _on_show_exhibition_endsTransition });
        _stateMap.put(ArtPieceContext.ArtPieceFSM.In_waitlist_for_auction, new Transition[] { _in_waitlist_for_auction_auction_day_arrivesTransition });
        _stateMap.put(ArtPieceContext.ArtPieceFSM.Out_side_of_collection, new Transition[] { _out_side_of_collection_authenticated_to_have_valueTransition });
        _stateMap.put(ArtPieceContext.ArtPieceFSM.In_the_art_collection, new Transition[] { _in_the_art_collection_damagedTransition });
        _stateMap.put(ArtPieceContext.ArtPieceFSM.In_waitlist_for_exhibition, new Transition[] { _in_waitlist_for_exhibition_exhibition_day_arrivesTransition });
        _stateMap.put(ArtPieceContext.ArtPieceFSM.On_auction, new Transition[] { _on_auction_not_soldTransition, _on_auction_soldTransition });

        initUI();
        reset();
        setVisible(true);
    }

    protected void initUI() {
        _currentState = new javax.swing.JTextField();
        _currentState.setEditable(false);
        javax.swing.JComponent lStateComponent = new javax.swing.JComponent() {};
        lStateComponent.setLayout(new java.awt.BorderLayout(5, 5));
        lStateComponent.add(new javax.swing.JLabel("Current state:"), java.awt.BorderLayout.WEST);
        lStateComponent.add(_currentState, java.awt.BorderLayout.CENTER);

        _optionGroup = new javax.swing.ButtonGroup();
        _optionPane = new javax.swing.JComponent() {};
        _optionPane.setLayout(new OptionLayout());
        javax.swing.JScrollPane lOptionScrollPane = new javax.swing.JScrollPane(_optionPane);
        lOptionScrollPane.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
        _processButton = new javax.swing.JButton("Proceed");
        _processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent aActionEvent) {
                processTransition();
            }
        });
        javax.swing.JComponent lProcessComponent = new javax.swing.JComponent() {};
        lProcessComponent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        lProcessComponent.add(_processButton);

        javax.swing.JComponent lOptionComponent = new javax.swing.JComponent() {};
        lOptionComponent.setLayout(new java.awt.BorderLayout(5, 5));
        lOptionComponent.add(new javax.swing.JLabel("Please select the next transition:"), java.awt.BorderLayout.NORTH);
        lOptionComponent.add(lOptionScrollPane, java.awt.BorderLayout.CENTER);
        lOptionComponent.add(lProcessComponent, java.awt.BorderLayout.SOUTH);

        _log = new javax.swing.JTextArea();
        _log.setEditable(false);
        javax.swing.JScrollPane lLogScrollPane = new javax.swing.JScrollPane(_log);
        lLogScrollPane.setSize(200, 150);
        lLogScrollPane.setPreferredSize(lLogScrollPane.getSize());
        javax.swing.JComponent lLogComponent = new javax.swing.JComponent() {};
        lLogComponent.setLayout(new java.awt.BorderLayout(5, 5));
        lLogComponent.add(new javax.swing.JLabel("Log:"), java.awt.BorderLayout.NORTH);
        lLogComponent.add(lLogScrollPane, java.awt.BorderLayout.CENTER);

        javax.swing.JComponent lLeftComponent = new javax.swing.JComponent() {};
        lLeftComponent.setLayout(new java.awt.BorderLayout(5, 5));
        lLeftComponent.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        lLeftComponent.add(lStateComponent, java.awt.BorderLayout.NORTH);
        lLeftComponent.add(lOptionComponent, java.awt.BorderLayout.CENTER);
        lLeftComponent.add(lLogComponent, java.awt.BorderLayout.SOUTH);

        javax.swing.JLabel lDiagram = new javax.swing.JLabel() {
            private java.awt.Point _pressedLocation;

            protected void processMouseEvent(java.awt.event.MouseEvent aMouseEvent) {
                switch (aMouseEvent.getID()) {
                    case java.awt.event.MouseEvent.MOUSE_PRESSED:
                        _pressedLocation = aMouseEvent.getPoint();
                        break;
                    case java.awt.event.MouseEvent.MOUSE_RELEASED:
                        _pressedLocation = null;
                    break;
                }
                super.processMouseEvent(aMouseEvent);
            }

            protected void processMouseMotionEvent(java.awt.event.MouseEvent aMouseEvent) {
                if (aMouseEvent.getID() == java.awt.event.MouseEvent.MOUSE_DRAGGED) {
                    java.awt.Rectangle lVisibleRectangle = getVisibleRect();
                    java.awt.Point lLocation = aMouseEvent.getPoint();
                    int lDragX = (int) _pressedLocation.getX() - (int) lLocation.getX();
                    int lDragY = (int) _pressedLocation.getY() - (int) lLocation.getY();
                    java.awt.Rectangle lNewVisibleRectangle = new java.awt.Rectangle((int) lVisibleRectangle.getX() + lDragX, (int) lVisibleRectangle.getY() + lDragY, (int) lVisibleRectangle.getWidth() + lDragX, (int) lVisibleRectangle.getHeight() + lDragY);
                    scrollRectToVisible(lNewVisibleRectangle);
                }
                super.processMouseMotionEvent(aMouseEvent);
            }
        };
        lDiagram.setAutoscrolls(true);
        javax.swing.ImageIcon lImageIcon = new javax.swing.ImageIcon(getClass().getClassLoader().getResource("diagram.png"));
        lDiagram.setIcon(lImageIcon);
        javax.swing.JScrollPane lDiagramScrollPane = new javax.swing.JScrollPane(lDiagram);
        lDiagramScrollPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        javax.swing.JButton lResetButton = new javax.swing.JButton("Reset");
        lResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent aActionEvent) {
                reset();
            }
        });
        javax.swing.JButton lExitButton = new javax.swing.JButton("Exit");
        lExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent aActionEvent) {
                System.exit(0);
            }
        });
        javax.swing.JComponent lButtonComponent = new javax.swing.JComponent() {};
        lButtonComponent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));
        lButtonComponent.add(lResetButton);
        lButtonComponent.add(lExitButton);

        javax.swing.JComponent lRightComponent = new javax.swing.JComponent() {};
        lRightComponent.setLayout(new java.awt.BorderLayout(5, 5));
        lRightComponent.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        lRightComponent.add(new javax.swing.JLabel("State Diagram", javax.swing.JLabel.CENTER), java.awt.BorderLayout.NORTH);
        lRightComponent.add(lDiagramScrollPane, java.awt.BorderLayout.CENTER);
        lRightComponent.add(lButtonComponent, java.awt.BorderLayout.SOUTH);

        javax.swing.JSplitPane lSplitPane = new javax.swing.JSplitPane();
        lSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        lSplitPane.setDividerSize(5);
        lSplitPane.setDividerLocation(300);
        lSplitPane.setLeftComponent(lLeftComponent);
        lSplitPane.setRightComponent(lRightComponent);

        javax.swing.JComponent lContainer = (javax.swing.JComponent) getContentPane();
        lContainer.setLayout(new java.awt.BorderLayout(5, 5));
        lContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lContainer.add(lSplitPane, java.awt.BorderLayout.CENTER);

        setTitle("ArtPiece");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setPreferredSize(getSize());
        java.awt.Dimension lScreenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((int) lScreenSize.getWidth() - 800) / 2, ((int) lScreenSize.getHeight() - 500) / 2);
    }

    protected void setArtPiece(ArtPiece aArtPiece) {
        _artPiece = aArtPiece;
    }

    protected ArtPiece getArtPiece() {
        return _artPiece;
    }

    protected void setSelectedTransition(Transition aSelectedTransition) {
        _selectedTransition = aSelectedTransition;
    }

    protected Transition getSelectedTransition() {
        return _selectedTransition;
    }

    protected void showState(ArtPiece aArtPiece) {
        _currentState.setText(aArtPiece.getContext().getState().getName());
    }

    protected void updateOptions(ArtPiece aArtPiece) {
        Transition[] lTransitions = (Transition[]) _stateMap.get(aArtPiece.getContext().getState());
        java.util.Enumeration lButtons = _optionGroup.getElements();
        while (lButtons.hasMoreElements()) {
            javax.swing.AbstractButton lButton = (javax.swing.AbstractButton) lButtons.nextElement();
            _optionGroup.remove(lButton);
        }
        _optionPane.removeAll();
        if (lTransitions != null) {
            for (int i = 0; i < lTransitions.length; i++) {
                _optionGroup.add(lTransitions[i].getButton());
                lTransitions[i].clear();
                _optionPane.add(lTransitions[i]);
                if (lTransitions.length > 0) {
                    lTransitions[0].getButton().setSelected(true);
                    setSelectedTransition(lTransitions[0]);
                }
                _processButton.setEnabled(true);
            }
        } else {
            _processButton.setEnabled(false);
        }
        _optionPane.revalidate();
        _optionPane.repaint();
    }

    protected void clearLog() {
        _log.setText("");
    }

    protected void addLog(String aLog) {
        _log.append(aLog);
        _log.append("\n");
        _log.setCaretPosition(_log.getText().length() - 1);
    }

    protected void processTransition() {
        Transition lTransition = getSelectedTransition();
        if (lTransition != null) {
            try {
                lTransition.proceed(getArtPiece(), lTransition.getArguments());
            } catch (Throwable aThrowable) {
                javax.swing.JOptionPane.showMessageDialog(this, aThrowable.toString(), getTitle(), javax.swing.JOptionPane.ERROR_MESSAGE);
            } finally {
                setSelectedTransition(null);
                showState(getArtPiece());
                updateOptions(getArtPiece());
            }
        }
    }

    public void reset() {
        clearLog();
        setArtPiece(new ArtPiece());
        showState(getArtPiece());
        updateOptions(getArtPiece());
        _artPiece.getContext().setDebugFlag(true);
        _artPiece.getContext().setDebugStream(new java.io.PrintStream(new java.io.OutputStream() {
            public void write(int i) throws java.io.IOException {
                _log.append("" + (char) i);
            }
        }));
    }

    public static void main(String[] aArguments) {
        new ArtPieceSample();
    }

    protected class OptionLayout implements java.awt.LayoutManager {
        public void addLayoutComponent(String aName, java.awt.Component aComponent) {}

        public void layoutContainer(java.awt.Container aParent) {
            java.awt.Component[] lComponents = aParent.getComponents();
            int lX = 0;
            int lY = 0;
            for (int i = 0; i < lComponents.length; i++) {
                java.awt.Dimension lPreferredSize = lComponents[i].getPreferredSize();
                int lWidth = (int) lPreferredSize.getWidth();
                int lHeight = (int) lPreferredSize.getHeight();
                lComponents[i].setBounds(lX, lY, lWidth, lHeight);
                lY += lHeight;
            }
        }

        public java.awt.Dimension minimumLayoutSize(java.awt.Container aParent) {
            return preferredLayoutSize(aParent);
        }

        public java.awt.Dimension preferredLayoutSize(java.awt.Container aParent) {
            java.awt.Component[] lComponents = aParent.getComponents();
            int lMaxWidth = 0;
            int lTotalHeight = 0;
            for (int i = 0; i < lComponents.length; i++) {
                java.awt.Dimension lPreferredSize = lComponents[i].getPreferredSize();
                lMaxWidth = Math.max(lMaxWidth, (int) lPreferredSize.getWidth());
                lTotalHeight += (int) lPreferredSize.getHeight();
            }
            return new java.awt.Dimension(lMaxWidth, lTotalHeight);
        }

        public void removeLayoutComponent(java.awt.Component aComponent) {}
    }

    protected abstract class Transition extends javax.swing.JComponent {
        private javax.swing.JRadioButton _button;
        private javax.swing.JTextField[] _fields;

        public Transition(String aText, String[] aParameterNames, Class[] aArguments) {
            initUI(aText, aParameterNames, aArguments);
        }
        protected void initUI(String aText, String[] aParameterNames, Class[] aArguments) {
            _button = new javax.swing.JRadioButton(aText);
            _button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent aActionEvent) {
                    setSelectedTransition(Transition.this);
                }
            });
            _fields = new javax.swing.JTextField[aArguments.length];
            for (int i = 0; i < _fields.length; i++) {
                _fields[i] = new javax.swing.JTextField(aParameterNames[i]);
                _fields[i].setName(aParameterNames[i]);
                _fields[i].setToolTipText(aParameterNames[i] + " : " + aArguments[i].getName());
                _fields[i].setSize(80, 20);
                _fields[i].setPreferredSize(_fields[i].getSize());
                _fields[i].addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent aFocusEvent) {
                        javax.swing.JTextField lTextField = (javax.swing.JTextField) aFocusEvent.getComponent();
                        lTextField.selectAll();
                        getButton().doClick();
                    }
                });
            }

            setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
            add(_button);
            for (int i = 0; i < _fields.length; i++) {
                add(_fields[i]);
            }
        }

        public javax.swing.AbstractButton getButton() {
            return _button;
        }

        public String getName() {
            return _button.getText();
        }

        public String[] getArguments() {
            String[] lArguments = new String[_fields.length];
            for (int i = 0; i < lArguments.length; i++) {
                lArguments[i] = _fields[i].getText();
            }
            return lArguments;
        }

        public void clear() {
            for (int i = 0; i < _fields.length; i++) {
                _fields[i].setText(_fields[i].getName());
            }
        }

        public abstract void proceed(ArtPiece aArtPiece, String[] aArguments);
    }

    protected class Authenticated_to_have_valueTransition extends Transition {
        public Authenticated_to_have_valueTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.authenticated_to_have_value()");
            aArtPiece.authenticated_to_have_value();
        }
    }

    protected class Recognized_as_unrepairableTransition extends Transition {
        public Recognized_as_unrepairableTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.recognized_as_unrepairable()");
            aArtPiece.recognized_as_unrepairable();
        }
    }

    protected class DamagedTransition extends Transition {
        public DamagedTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.damaged()");
            aArtPiece.damaged();
        }
    }

    protected class Exhibition_day_arrivesTransition extends Transition {
        public Exhibition_day_arrivesTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.exhibition_day_arrives()");
            aArtPiece.exhibition_day_arrives();
        }
    }

    protected class Auction_day_arrivesTransition extends Transition {
        public Auction_day_arrivesTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.auction_day_arrives()");
            aArtPiece.auction_day_arrives();
        }
    }

    protected class Exhibition_endsTransition extends Transition {
        public Exhibition_endsTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.exhibition_ends()");
            aArtPiece.exhibition_ends();
        }
    }

    protected class Not_soldTransition extends Transition {
        public Not_soldTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.not_sold()");
            aArtPiece.not_sold();
        }
    }

    protected class SoldTransition extends Transition {
        public SoldTransition(String aText, String[] aParameterNames, Class[] aArguments) {
            super(aText, aParameterNames, aArguments);
        }

        public void proceed(ArtPiece aArtPiece, String[] aArguments) {
            String lArguments = "";
            for (int i = 0; i < aArguments.length; i++) {
                if (i > 0) {
                    lArguments += ", ";
                }
                lArguments += aArguments[i];
            }
            addLog("[Call] ArtPiece.sold()");
            aArtPiece.sold();
        }
    }
}