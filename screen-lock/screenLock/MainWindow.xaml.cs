using System;
using System.Collections.Generic;
using System.Linq;
using System.Media;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace screenLock
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {


        

        public MainWindow()
        {
            InitializeComponent();


            var desktopWorkingArea = SystemParameters.WorkArea;
            Left = (desktopWorkingArea.Right - this.Width) / 3;
            Top = 0;




        }
        
        

       
        private void lockButton_MouseRightButtonDown(object sender, MouseButtonEventArgs e)
        {
            //Closing = "lockWindow_Closing"
            Close();
        }

        private void lockButton_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            SystemSounds.Beep.Play();
            LockWindow lockedWindow = new LockWindow();
            lockedWindow.Show();
            //Console.WriteLine("closing \n\n\n\nashdghasgdjasgd");
            Util.lockingTime = DateTime.Now;
            Close();
        }
    }
}
