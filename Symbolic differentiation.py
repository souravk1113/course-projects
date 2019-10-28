
#functions for division,multiplication,subtraction,exponentiation and some other helping functions for log
# and these functions are completely implemented by me without any help 
#used product rule for differentiation
#used quotient rule for differentiation
#used the fact that derivative of f(x)^g(x)= (diffrentiate considering g(x) constant)+ (differentiate considering f(x) constant)
class expr:

    def __init__(self,S,Nd = None):
        if (Nd):
            self.expr = Nd
        else:
            (e,n) = self.parse(S)
            self.expr = e

    class Node:
        def __init__(self,d):
            self.left = None
            self.right = None
            self.data = d
        
        def toString(self):
            if (self.left and self.right):
                left = self.left.toString()
                right = self.right.toString()
                opr = self.data
                return "(" + left + " " + opr + " " + right + ")"
            else:
                return self.data

    def prettyprint(self):
        s = self.expr.toString()
        print(s)
    def exprtostr(self):
        s=self.expr.toString()
        return s
        

    def parse(self,S):
        l = len(S)
        if (S[0] == "("):
            (left,n) =  self.parse(S[1:l-2])
            opr = S[n+1]
            (right,m) = self.parse(S[n+2:l-1])
            expr = self.Node(opr)
            expr.left = left
            expr.right = right
            return (expr,n+m+3)
        elif S[0].isdigit():
            i = 0
            while ((i < l) and (S[i].isdigit() or (S[i] == "."))):
                i = i+1
            num = S[0:i]
            expr = self.Node(num)
            return (expr,i)
        elif S[0].isalpha():
            i = 0
            while ((i < l) and S[i].isalpha()):
                i = i+1
            var = S[0:i]
            expr = self.Node(var)
            return (expr,i)
        else:
            return Exception("Invalid input")

    def constant(self):
        if self.expr.data[0].isdigit():
            return True
        else:
            return False

    def variable(self):
        if self.expr.data[0].isalpha():
            return True
        else:
            return False

    def samevariable(self,x):
        if (self.expr.data == x):
            return True
        else:
            return False

    def sum(self):
        if (self.expr.data == '+'):
            return True
        else:
            return False
    def product(self):
                if (self.expr.data == "*"):
                        return  True
                else:
                        return False
    def division(self):
                if (self.expr.data =="/"):
                        return True
                else:
                        return False
    def diff(self):
                if (self.expr.data=="-"):
                        return True
                else:
                        return False
    def exp(self):
                if(self.expr.data=="^"):
                        return  True
                else:
                        return False

    def addend(self):
        left = self.expr.left
        return expr("",left)

    def augend(self):
        right = self.expr.right
        return expr("",right)

    def makesum(self,e1,e2):
        if e1.exprtostr()!="0.0" and e2.exprtostr()!="0.0":
            e = self.Node("+")  

        
            e.left = e1.expr
            e.right = e2.expr
            return expr("",e)
        else:
            if e1.exprtostr()!="0.0":
                e=self.Node(e1.exprtostr())
            else:
                e=self.Node(e2.exprtostr())
            return expr("",e)
    def makelog(self,s):
                e=self.Node("ln"+s)
                e.left=None
                e.right=None
                return expr("",e)
    def makeproduct(self,e1,e2):
        if e1.exprtostr()!="0.0" and e2.exprtostr()!="0.0":
            e=self.Node("*")
            e.left=e1.expr
            e.right=e2.expr
            return expr("",e)
        else:
            e=self.Node("0.0")
            return expr("",e)
    def makedivision(self,e1,e2):
        if e1.exprtostr()!="0.0":

            e=self.Node("/")
            e.left=e1.expr
            e.right=e2.expr
        else:
            e=self.Node("0.0")
        return expr("",e)
    def makediff(self,e1,e2):
        if e2.exprtostr()!="0.0":
            e = self.Node("-")  

        
            e.left = e1.expr
            e.right = e2.expr
            return expr("",e)
        else:
            if e1.exprtostr()!="0.0":
                e=self.Node(e1.exprtostr())
            elif e2.exprtostr()!="0.0":
                e=self.Node(e2.exprtostr())
            else:
                e=self.Node("0.0")
            return expr("",e)
    def makeexp(self,e1,e2):
                e=self.Node("^")
                e.left=e1.expr
                e.right=e2.expr
                return expr("",e)

    def deriv(self,x):
        if self.constant():
            return expr("0.0")
        if self.variable():
            if self.samevariable(x):
                return expr("1.0")
            else:
                return expr("0.0")
        elif self.sum():
                e1 = self.addend()
                e2 = self.augend()
                return self.makesum(e1.deriv(x),e2.deriv(x))
        elif self.product():
                    e1=self.addend()
                    e2=self.augend()
                    return self.makesum(self.makeproduct(e1.deriv(x),e2),self.makeproduct(e2.deriv(x),e1))
        elif self.division():
                    e1=self.addend()
                    e2=self.augend()
                    return self.makedivision((self.makediff(self.makeproduct(e1.deriv(x),e2),self.makeproduct(e2.deriv(x),e1))),self.makeproduct(e2,e2))
        elif self.diff():
                    e1=self.addend()
                    e2=self.augend()
                    return self.makediff(e1.deriv(x),e2.deriv(x))
        elif self.exp():
                e1=self.addend()
                e2=self.augend()
                return self.makesum(self.makeproduct(self.makeproduct(e2,self.makeexp(e1,self.makediff(e2,expr(str(1))))),e1.deriv(x)),self.makeproduct(self.makeproduct(e2.deriv(x),self),self.makelog(str(e1.exprtostr()))))
        else:
            raise Exception("DontKnowWhatToDo!")
                

a = input("Enter an expression:")
e = expr(a)
e.prettyprint()
f = e.deriv('x')
f.prettyprint()
#time comlexity analysis of deriv function: let number of nodes in
#expresion tree be n then T(n)=T(n-i-1)+T(i)+O(1)
#averaging for values of i : T(n)= summation(j=1 to (n-2))(T(j)+T(n-j-1))/(n-2) + k
#=> T(n)=summation(j=1 to j=n-2)2*T(i)/(n-2)+ k
#=>T(n-1)=summation(j=1 to j=n-3)2T(i)/(n-3) +k
#=>T(n)*(n-2)=(n-3)T(n-1)=2*T(n-2) +k
#=>T(1)=1, T(2)=2...... T(n)=O(n)
